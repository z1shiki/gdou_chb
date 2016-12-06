package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 收货地址
 * Created by WT on 2016/11/29.
 */

public class Address implements Serializable{
    /**
     * 地址ID
     */
    private long addressId;
    /**
     * 地址名称
     */
    private String address;
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 经度
     */
    private double longitude;
    /**
     * 收货人名称
     */
    private String name;
    /**
     * 用户id
     */
    private long userId;
    /**
     * 手机号
     */
    private long phone;


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}