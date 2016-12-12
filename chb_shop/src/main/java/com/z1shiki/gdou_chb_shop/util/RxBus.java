package com.z1shiki.gdou_chb_shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Z1shiki on 2016/11/25.
 */

public class RxBus {

    /**
     * 事件总线的核心。
     */
    private final Subject<Object,Object> bus;

    /**
     * 黏性事件存储的Map
     */
    private final ConcurrentHashMap<Class<?>,List<Object>> mStickyEventMap;


    /**
     * 构造函数，初始化一些东西
     */
    private RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
        mStickyEventMap = new ConcurrentHashMap<>();
    }

    /** 单例模式
     * @return
     */
    public static RxBus getDefault() {
        return HelperHolder.instance;
    }

    /**
     * 延迟初始化，这里是利用了 Java 的语言特性，内部类只有在使用的时候，才会去加载，
     * 从而初始化内部静态变量。关于线程安全，这是 Java 运行环境自动给你保证的，
     * 在加载的时候，会自动隐形的同步。在访问对象的时候，
     * 不需要同步 Java 虚拟机又会自动给你取消同步，所以效率非常高。
     */
    private static class HelperHolder {
        public static final RxBus instance = new RxBus();
    }

    /** 发送普通事件
     * @param object
     */
    public void post(Object object){
        bus.onNext(object);
    }

    /** 发送黏性事件
     * 观察者接收以后并不会消耗事件，除非手动清除
     * 发送的事件不会覆盖前面的事件
     * @param object
     */
    public void postSticky(Object object){
        synchronized (mStickyEventMap){
            List list = mStickyEventMap.get(object.getClass());
            if (list == null) {
                list = new ArrayList();
            }
            list.add(object);
            mStickyEventMap.put(object.getClass(),list);
        }
        post(object);
    }

    /**
     * 发送黏性事件，并且会覆盖掉所有相同类的事件，只保留这一个
     * @param object
     */
    public void postStickyAndCover(Object object){
        synchronized (mStickyEventMap){
            List list = mStickyEventMap.get(object.getClass());
            if (list == null) {
                list = new ArrayList();
            }
            list.clear();
            list.add(object);
            mStickyEventMap.put(object.getClass(),list);
        }
        post(object);
    }
    /**
     * 接收事件总线上所有 eventTpye这个事件
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }


    public <T> Observable<T> toObservableLastSticky(final Class<T> eventType){
        synchronized (mStickyEventMap){
            Observable<T> observable = bus.ofType(eventType);
            final List list =  mStickyEventMap.get(eventType);
            if (list != null && !list.isEmpty()) {
                return observable.mergeWith(Observable.create(new Observable.OnSubscribe<T>(){

                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        //把list最后一项发出来
                        subscriber.onNext(eventType.cast(list.get(list.size()-1)));
                    }
                }));
            }else {
                return observable;
            }
        }
    }

    /**
     * 接收事件总线上所有 eventType这个事件
     * 如果mStickyEventMap中保存有eventType的黏性事件则和普通事件一起接收
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservableSticky(final Class<T> eventType){
        synchronized (mStickyEventMap){
            Observable<T> observable = bus.ofType(eventType);
            final List list =  mStickyEventMap.get(eventType);
            if (list != null && !list.isEmpty()) {
                return observable.mergeWith(Observable.create(new Observable.OnSubscribe<T>(){

                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        for (Object obj :
                                list) {
                            subscriber.onNext(eventType.cast(obj));
                        }
                    }
                }));
            }else {
                return observable;
            }
        }
    }

    /**
     * 接收事件总线上所有 eventType这个事件,同时删除这个类对应的黏性事件
     * 如果mStickyEventMap中保存有eventType的黏性事件则和普通事件一起接收
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservableStickyAndRemove(final Class<T> eventType){
        synchronized (mStickyEventMap){
            Observable<T> observable = bus.ofType(eventType);
            final List list =  mStickyEventMap.get(eventType);
            if (list != null && !list.isEmpty()) {
                removeStickyEventClass(eventType);
                return observable.mergeWith(Observable.create(new Observable.OnSubscribe<T>(){

                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        for (Object obj :
                                list) {
                            subscriber.onNext(eventType.cast(obj));
                        }
                    }
                }));
            }else {
                return observable;
            }
        }
    }

    /**
     * 移除某个类的一个对象
     */
    public void removeStickyEvent(Object object){
        synchronized (mStickyEventMap){
            List list = mStickyEventMap.get(object.getClass());
            if (list != null) {
                list.remove(object);
            }
        }
    }

    /**
     * 移除某个类所有的对象
     */
    public <T> void removeStickyEventClass(Class<T> eventType){
        synchronized (mStickyEventMap){
            mStickyEventMap.remove(eventType);
        }
    }

    /**
     * 清除所有的Sticky事件
     */
    public void removeAllStickEvent(){
        synchronized (mStickyEventMap){
            mStickyEventMap.clear();
        }
    }
}
