package com.z1shiki.gdou_chb_shop.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.contract.HomeContract;
import com.z1shiki.gdou_chb_shop.model.bean.ResultBean;
import com.z1shiki.gdou_chb_shop.model.bean.Shop;
import com.z1shiki.gdou_chb_shop.model.impl.ShopModelImpl;
import com.z1shiki.gdou_chb_shop.util.GsonUtils;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Z1shiki on 2016/11/30.
 */

public class HomePresenter implements HomeContract.ShopPresenter {

    private CompositeSubscription mSubscription;
    private final HomeContract.ShopView mHomeView;
    //Home需要操作的数据 地址 商家
    private String mAddress;

    private Context mContext;
    private ShopModelImpl mShopModel;

    public HomePresenter(Context context, @Nullable HomeContract.ShopView homeView)
    {
        mHomeView = homeView;
        mShopModel = new ShopModelImpl();
        mContext = context;
        mSubscription = new CompositeSubscription();
        mHomeView.setPresenter(this);
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }



    @Override
    public void getGPS() {
    }

    @Override
    public void changelocation() {
        mHomeView.setLocation(mAddress);
//        TODO:从本地地址数据库选择地址、
//         新的地址的经纬发送给数据层、从数据层获得新的商家列表
//        mHomeView.changeShoplist(维护的商家列表参数);  修改商店列表的方法
    }

    @Override
    public void doSerach() {
        //TODO : 发送搜索栏里的值给商家列表
        //返回新的商家列表
        Log.i("btb", "doSerach: ");
//        mHomeView.changeShoplist(维护的商家列表参数); 数据层返回了搜索过后的新的商家列表
    }

    @Override
    public void getShopList() {
        Subscription subscription =
                mShopModel
                        .Shop()
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
                                           Log.d("Shop", "succ");
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           Log.e("Shop Error", "onError: ", e);
                                           Log.d("Shop","error");
                                       }

                                       @Override
                                       public void onNext(String string) {
                                           ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                           Log.d("shopsList", GsonUtils.getJsonStr(resultBean.getResultParm()));
                                           List<Shop> shopList = GsonUtils.
                                                   getBeanFromResultBeanListMiss(resultBean, "shopList", Shop[].class);
                                           Log.d("shopsList", "onNext: " + GsonUtils.getJsonStr(shopList));
                                           Log.d("List", shopList.size() + "");

                                           mHomeView.changeShoplist(shopList);
                                       }
                                   }
                        );
        mSubscription.add(subscription);
    }
}
