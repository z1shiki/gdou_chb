package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * Created by WT on 2016/11/29.
 */

public class Shop  implements Serializable{
	/**
	 * 商店Id
	 */
	private long id;

	/**
	 * 起送价
	 */
	private int startingPrice;
	/**
	 * 配送费
	 */
	private int distributionFee;
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

	private String createdDate;

	public Shop(String shopName) {
		this.shopName = shopName;
	}

	public Shop() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getDistributionFee() {
		return distributionFee;
	}

	public void setDistributionFee(int distributionFee) {
		this.distributionFee = distributionFee;
	}

	public int getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"id=" + id +
				", startingPrice=" + startingPrice +
				", distributionFee=" + distributionFee +
				", latitude=" + latitude +
				", loongitude=" + loongitude +
				", shopName='" + shopName + '\'' +
				", openTime=" + openTime +
				", stopTime=" + stopTime +
				", createdDate='" + createdDate + '\'' +
				'}';
	}
}