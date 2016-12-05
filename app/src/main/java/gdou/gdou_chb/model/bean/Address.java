package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 收货地址
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:35
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
}