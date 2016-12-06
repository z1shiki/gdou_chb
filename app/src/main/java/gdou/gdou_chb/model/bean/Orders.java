package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 订单
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:38
 */

public class Orders implements Serializable{
    /**
     * 订单ID
     */
    private long ordersId;

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }
}