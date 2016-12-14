package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Orders;
import rx.Observable;

/**
 * Created by MissYou on 2016/12/14.
 * 支付接口
 */
public interface PayModel {

    /**
     * 下单
     * @param orders
     * @param goodsList
     * @return
     */
    Observable<Result> placeOrder(Orders orders, String goodsList);

    /**
     * 支付订单
     * @param ordersId
     * @param payWay 支付方式
     * @return
     */
    Observable<Result> payOrder(Long ordersId, String payWay);
}
