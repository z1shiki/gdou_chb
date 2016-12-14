package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.PayModel;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by MissYou on 2016/12/14.
 */

public class PayModelImpl implements PayModel {
    @Override
    public Observable<Result> placeOrder(Orders orders, String goodsList) {
        HttpParams params = new HttpParams();
        params.put("goodsList", goodsList);
        params.put("addressId", orders.getAddressId());
        params.put("totalPrice", orders.getTotalPrice() + "");
        params.put("userId", orders.getUserId() + "");
        params.put("shopUserId", orders.getShopUserId() + "");
        return RxVolleyUtils
                .getInstance()
                .post(BaseModelImpl.Service_URL + BaseModelImpl.placeOrder_URL, params);
    }

    @Override
    public Observable<Result> payOrder(Long ordersId, String payWay) {
        HttpParams params = new HttpParams();
        params.put("ordersId", ordersId + "");
        params.put("payWay", payWay);
        return RxVolleyUtils
                .getInstance()
                .post(BaseModelImpl.Service_URL + BaseModelImpl.pay_Order_URL, params);
    }
}
