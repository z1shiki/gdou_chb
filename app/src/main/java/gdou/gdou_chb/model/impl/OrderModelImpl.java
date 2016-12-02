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
    /**
     * 用户下单
     * @param orders
     * @return
     */
    @Override
    public Observable<Result> placeOrder(Orders orders) {
            HttpParams params = new HttpParams();
            params.put("orders", String.valueOf(orders));
            return RxVolleyUtils.getInstance().post(
                    BaseModelImpl.Service_URL + BaseModelImpl.placeOrder_URL
                    ,params);
        }

    /**
     * 用户完成订单
     * @param ordersId
     * @return
     */

    @Override
    public Observable<Result> doneOrders(long ordersId) {
        HttpParams params = new HttpParams();
        params.put("ordersId", String.valueOf(ordersId));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.doneOrders_URL
                ,params);
    }

    /**
     * 申请退单
     * @param ordersId
     * @return
     */

    @Override
    public Observable<Result> rebackOrders(long ordersId) {
        HttpParams params = new HttpParams();
        params.put("rebackOrders", String.valueOf(ordersId));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.rebackOrders_URL
                ,params);
    }
}
