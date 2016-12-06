package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Goods;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.model.bean.User;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface OrderModel {
    /**
     * 用户下单
     * @param orders
     * @param user
     * @param shop
     * @param goods
     * @return
     */
    Observable<Result> placeOrder(Orders orders, User user, Shop shop, Goods goods);
    /**
     * 用户完成订单
     * @param orders
     * @return
     */
    Observable<Result> doneOrders(Orders orders);
    /**
     * 用户申请退单
     * @param orders
     * @return
     */
    Observable<Result> UserAllOrders(User user);
}
