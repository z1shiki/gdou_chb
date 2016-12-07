package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.model.OrderModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class OrderModelImpl implements OrderModel {
    @Override
    public Observable<Result> placeOrder(Orders orders, String goodsList) {
        HttpParams params  = new HttpParams();
        params.put("goodList", goodsList);
        params.put("userId", String.valueOf(orders.getUserId()));
        params.put("shopId", String.valueOf(orders.getShopId()));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.placeOrder_URL
                ,params);
    }

    @Override
    public Observable<Result> doneOrders(Orders orders) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", String.valueOf(orders.getOrdersId()));
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.doneOrders_URL + orders.getOrdersId()
                ,params);
    }

    @Override
    public Observable<Result> rebackOrders(Orders orders) {
        HttpParams params  = new HttpParams();
        params.put("ordersId", String.valueOf(orders.getOrdersId()));
        return  RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.rebackOrders_URL + orders.getOrdersId()
                ,params);
    }

    @Override
    public Observable<Result> UserAllOrders(Orders orders) {
        HttpParams params  = new HttpParams();
        params.put("usrId", String.valueOf(orders.getUserId()));
        return  RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.userAllOrders_URL + orders.getUserId()
                ,params);
    }
}
