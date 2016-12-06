package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * Created by WT on 2016/11/29.
 */

public class Shop  implements Serializable{
	/**
	 * 商店Id
	 */
	private long shopId;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 经度
	 */
	private double loongitude;
	/**
	 * 商店名字
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

	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public Shop() {

	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLoongitude() {
		return loongitude;
	}

	public void setLoongitude(double loongitude) {
		this.loongitude = loongitude;
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
}