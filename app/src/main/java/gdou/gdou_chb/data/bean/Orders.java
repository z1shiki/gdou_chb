package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 订单
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:38
 */

public class Orders implements Serializable{

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
	 */
	private int status;
	
	/**
	 * 订单总价
	 */
	private int totalPrice;
	
	/**
	 * 操作的用户
	 */
	private long userId;
	
	private long shopUserId;
	
	public long getShopUserId() {
		return shopUserId;
	}

	public void setShopUserId(long shopUserId) {
		this.shopUserId = shopUserId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * 订单是否已经处理
	 */
	private boolean watch;
	
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

	public int getTotalPrice() {
		return totalPrice;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isWatch() {
		return watch;
	}

	public void setWatch(boolean watch) {
		this.watch = watch;
	}

}