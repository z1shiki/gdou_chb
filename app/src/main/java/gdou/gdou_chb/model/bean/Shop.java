package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 商店
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:39
 */

public class Shop implements Serializable{
    /**
     * 商店ID
     */
    private long shopId;
    /**
     * 商店名称
     */
    private String shopName;
    /**
     * 开店时间
     */
    private int openTime;
    /**
     * 关店时间
     */
    private int stopTime;
    /**
     * 商店纬度
     */
    private double latitude;
    /**
     * 商店经度
     */
    private double longitude;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
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
}