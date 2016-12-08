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
     * 地址Id
     */
    private long addressId;
    /**
     * 商品数量
     */
    private long Number;
    /**
     * 订单ID
     */
    private long id;

    /**
     * 订单总价
     */
    private long totalPrice;

    /**
     * 订单状态
     */
    private int status;
    /**
     * 点单地址
     */
    private String address;
    /**
     * 点单用户名
     */
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "userId=" + userId +
                ", shopId=" + shopId +
                ", addressId=" + addressId +
                ", Number=" + Number +
                ", id=" + id +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}