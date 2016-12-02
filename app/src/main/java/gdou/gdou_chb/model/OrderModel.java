package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Orders;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public interface OrderModel {
    /**
     * 客户下单
     * @param orders
     * @return
     */
    Observable<Result> placeOrder(Orders orders );

    /**
     * 用户完成订单
     * @param ordersId
     * @return
     */
    Observable<Result> doneOrders(long ordersId);

    /**
     * 用户申请退单
     * @param ordersId
     * @return
     */
    Observable<Result> rebackOrders(long ordersId );
}
