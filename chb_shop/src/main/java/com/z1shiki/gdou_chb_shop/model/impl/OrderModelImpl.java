package com.z1shiki.gdou_chb_shop.model.impl;

import android.util.Log;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.model.OrderModel;
import com.z1shiki.gdou_chb_shop.model.bean.Orders;
import com.z1shiki.gdou_chb_shop.util.RxVolleyUtils;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class OrderModelImpl implements OrderModel {
    @Override
    public Observable<Result> placeOrder(Orders orders, String goodsList) {
        HttpParams params  = new HttpParams();
        params.put("goodsList", goodsList);
        params.put("addressId", String.valueOf(orders.getAddressId()));
        params.put("userId", String.valueOf(orders.getUserId()));
        params.put("shopUserId", String.valueOf(orders.getShopId()));
        Log.d("用户ID", "userId: " + orders.getUserId());
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.placeOrder_URL
                ,params);
    }

    @Override
    public Observable<Result> doneOrders(Long orderId) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", orderId + "");
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.doneOrders_URL + orderId
                ,params);
    }

    @Override
    public Observable<Result> rebackOrders(Long orderId) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", orderId + "");
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.rebackOrders_URL + orderId
                ,params);
    }

    @Override
    public Observable<Result> UserAllOrders(Long userId) {
        HttpParams params  = new HttpParams();
        params.put("usrId", String.valueOf(userId));
        return  RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.userAllOrders_URL + userId
                ,params);
    }

    @Override
    public Observable<Result> getOrderDetail(Long orderId) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", String.valueOf(orderId));
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.ordersInfo_URL + orderId
                ,params);
    }
}
