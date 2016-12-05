package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 商品基本信息
 * @author Administrator
 * @version 1.0
 * @created 23-十一月-2016 16:59:43
 */

public class Goods implements Serializable {
    /**
     * 商品Id
     */
    private long goodId;
    /**
     * 商品数量
     */
    private long number;
    /**
     * 商品单价
     */
    private long price;

    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}