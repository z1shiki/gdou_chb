package gdou.gdou_chb.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 订单
 * Created by WT on 2016/11/29.
 */

public class Orders implements Serializable{
    /**
     * 用户Id
     */
    private long userId;
    /**
     * 商店Id
     */
    private long shopId;
    /**
     * 商品数量
     */
    private long Number;
    /**
     * 订单ID
     */
    private long ordersId;

    /**
     * 订单总价
     */
    private long totalPrice;

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getNumber() {
        return Number;
    }

    public void setNumber(long number) {
        Number = number;
    }
}