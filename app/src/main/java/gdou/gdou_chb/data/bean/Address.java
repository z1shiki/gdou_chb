package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 收货地址
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:35
 */

public class Address extends BaseBean  implements Serializable{

	/**
	 * 地址名字
	 */
	private String address;
	
	/**
	 * 是否是用户默认地址
	 */
	private boolean isDefault;
	
	/**
	 * 纬度
	 */
	private double latitude;
	
	/**
	 * 经度
	 */
	private double longitude;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
}