package com.z1shiki.gdou_chb_shop.presenter;

import android.util.Log;

import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.contract.HomeContract;
import com.z1shiki.gdou_chb_shop.model.bean.Orders;
import com.z1shiki.gdou_chb_shop.model.bean.ResultBean;
import com.z1shiki.gdou_chb_shop.model.impl.BaseModelImpl;
import com.z1shiki.gdou_chb_shop.model.impl.OrderModelImpl;
import com.z1shiki.gdou_chb_shop.util.GsonUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Z1shiki on 2016/12/5.
 */

public class OrderPresenter implements HomeContract.OrderPresenter {
    private final OrderModelImpl mModel;
    private final HomeContract.OrderView mOrderView;
    private final  CompositeSubscription mSubscription;
//    private Subscription subscription;
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }

    public OrderPresenter(HomeContract.OrderView view, OrderModelImpl orderModel) {
        mOrderView = view;
        mOrderView.setPresenter(this);
        mModel=orderModel;
        mSubscription = new CompositeSubscription();

    }
    @Override
    public void initData() {
        final Subscription subscription =
                mModel.UserAllOrders(BaseModelImpl.user.getId())
                        .map(new Func1<Result, String>() {
                            @Override
                            public String call(Result result) {
                                return new String(result.data);
                            }
                        } )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<String>() {
                                       @Override
                                       public void onCompleted() {
                                           Log.d("orderslist", "succ");
                                           mOrderView.Datachanged();
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           Log.d("orderslist","error");
                                           Log.e("orderList", "onError: 错误信息",e );
                                       }

                                       @Override
                                       public void onNext(String string) {
                                           Log.d("Orders", "orders: " + string);
                                           ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                           //解析成对应的对象
                                           List<Orders> ordersList = GsonUtils.getBeanFromResultBeanListMiss(resultBean, "orderList", Orders[].class);
                                           ArrayList<Orders> mOrderList = new ArrayList<Orders>();
                                           for (Orders orders : ordersList)
                                               mOrderList.add(orders);
                                           mOrderView.setAdapter(mOrderList);
                                       }
                                   });
        mSubscription.add(subscription);
    }
    @Override
    public void doenOrder(Long orderId) {
        Log.d("Order", "doenOrder: " + orderId);

        final Subscription subscription = mModel.doneOrders(orderId)
                .map(new Func1<Result, String>() {
                    @Override
                    public String call(Result result) {
                        return new String(result.data);
                    }
                } )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                               @Override
                               public void onCompleted() {
                                   Log.d("OrderDone", "succ");
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.d("OrderDone","error");
                                   Log.e("OrderDone", "onError: 错误信息",e );
                               }

                               @Override
                               public void onNext(String string) {
                                   Log.d("OrderDone","result:" + string);
                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                   //解析成对应的对象

                               }
                           });
        mSubscription.add(subscription);

    }
    @Override
    public void backOrder(Long orderId) {
        Log.d("Order", "backOrder: " + orderId);
        final Subscription subscription =mModel.rebackOrders(orderId)
                .map(new Func1<Result, String>() {

                    @Override
                    public String call(Result result) {
                        return new String(result.data);
                    }
                } )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                               @Override
                               public void onCompleted() {
                                   Log.d("OrderBack", "succ");
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.d("OrderBack","error");
                                   Log.e("OrderBack", "onError: 错误信息",e );
                               }

                               @Override
                               public void onNext(String string) {
                                   Log.d("OrderBack","result:" + string);
                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                   //解析成对应的对象


                               }
                           });
        mSubscription.add(subscription);
    }
}
