package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 商店
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:39
 */

public class Shop  extends BaseBean implements Serializable{
	
	/**
	 * 营业时间
	 */
	private int openTime;
	/**
	 * 配送费
	 */
	private int distributionFee;
	/**
	 * 是否营业
	 */
	private int isOnline;
	/**
	 * 评分
	 */
	private int score;
	/**
	 * 起送价
	 */
	private int startingPrice;
	/**
	 * 关闭时间，没有营业时间
	 */
	private int stopTime;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 经度
	 */
	private double longitude;
	/**
	 * 商店名称
	 */
	private String shopName;
	/**
	 * 营业许可
	 */
	private int license;
	/**
	 * 商店图片
	 */
	private int shopImg;
	/**
	 * 当商店处于非营业状态时候，永远不会被搜索出来 当商店处于营业状态时候，并且处于当天的营业时间， 用户才能够下订单，不处于营业时间的商店也能够被搜索，
	 * 被后台管理强制处于非营业状态的商家无法自己改变状态
	 * 1.商店营业
	 * 2.商店关闭
	 * 3.商店被后台管理关闭
	 */
	private int status;
	
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public int getShopImg() {
		return shopImg;
	}
	public void setShopImg(int shopImg) {
		this.shopImg = shopImg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOpenTime() {
		return openTime;
	}
	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}
	public int getDistributionFee() {
		return distributionFee;
	}
	public void setDistributionFee(int distributionFee) {
		this.distributionFee = distributionFee;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStartingPrice() {
		return startingPrice;
	}
	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	private String name;
	//private int imgId;

	public Shop(String name/*, int imgId*/){
		this.name = name;
		//this.imgId = imgId;
	}

	public void setName(String name){
		this.name = name;
	}

	//public void setImgId(int imgId){
		//this.imgId = imgId;
	//}

	public String getName() {
		return name;
	}

	//public int getImgId() {
		//return imgId;
	//}
}