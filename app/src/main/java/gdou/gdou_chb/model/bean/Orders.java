package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 订单
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:38
 */
public class Orders implements Serializable{

	/**
	 * 订单ID
	 */
	private Integer id;

	/**
	 * 点单创建时间
	 */
	private String createdDate;

	/**
	 * 有多少种商品
	 */
	private int number;
	/**
	 * 1、已下单未支付      已下单
	 * 2、已支付未接单      已支付
	 * 3、已接单未配送      已接单
	 * 4、已配送未送达      正在配送
	 * 5、已送达未评价      待评价
	 * 6、已评价（完成）
	 * 7、订单取消
	 * 8、申请退单但是审核失败
	 */
	private int status;
	
	/**
	 * 订单总价
	 */
	private float totalPrice;
	
	/**
	 * 操作的用户
	 */
	private long userId;

	/**
	 * 商店用户Id(商家Id)
	 */
	private long shopUserId;
	
	/**
	 * 订单支付方式
	 * 1.在线支付
	 * 2.线下支付
	 */
	private int payType;
	
	/**
	 * 订单是否已经处理
	 */
	private boolean watch;

	/**
	 * 收货地址
	 */
	private String address;
	/**
	 * 收货人姓名
	 */
	private String name;
	/**
	 * 收货人手机
	 */
	private String phone;

	private int shopId;

	private  int addressId;
	
	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public long getShopUserId() {
		return shopUserId;
	}

	public void setShopUserId(long shopUserId) {
		this.shopUserId = shopUserId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return totalPrice;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isWatch() {
		return watch;
	}

	public void setWatch(boolean watch) {
		this.watch = watch;
	}

	/**
	 * Getter for property 'address'.
	 *
	 * @return Value for property 'address'.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for property 'address'.
	 *
	 * @param address Value to set for property 'address'.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for property 'name'.
	 *
	 * @return Value for property 'name'.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for property 'name'.
	 *
	 * @param name Value to set for property 'name'.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for property 'phone'.
	 *
	 * @return Value for property 'phone'.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for property 'phone'.
	 *
	 * @param phone Value to set for property 'phone'.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Orders{" +
				"id=" + id +
				", createdDate='" + createdDate + '\'' +
				", number=" + number +
				", status=" + status +
				", totalPrice=" + totalPrice +
				", userId=" + userId +
				", shopUserId=" + shopUserId +
				", payType=" + payType +
				", watch=" + watch +
				", address='" + address + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", shopId=" + shopId +
				", addressId=" + addressId +
				'}';
	}
}