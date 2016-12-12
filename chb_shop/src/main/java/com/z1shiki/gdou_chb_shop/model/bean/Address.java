package com.z1shiki.gdou_chb_shop.model.bean;

import java.io.Serializable;

/**
 * 收货地址
 * Created by WT on 2016/11/29.
 */

public class Address implements Serializable{
    /**
     * 地址ID
     */
    private long id;
    /**
     * 地址名称
     */
    private String addressName;
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
    private String phone;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                '}';
    }
}