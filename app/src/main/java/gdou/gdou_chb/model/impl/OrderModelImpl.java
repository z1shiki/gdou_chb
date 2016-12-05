package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Goods;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.model.OrderModel;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class OrderModelImpl implements OrderModel {
    @Override
    public Observable<Result> placeOrder(Orders orders, User user, Shop shop, Goods goods) {
        return null;
    }

    @Override
    public Observable<Result> doneOrders(Orders orders) {
        return null;
    }

    @Override
    public Observable<Result> UserAllOrders(User user) {
        return null;
    }
}
