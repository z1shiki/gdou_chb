package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 订单详情
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:38
 */

public class OrderDetail extends BaseBean implements Serializable{
	
	/**
	 * 商品名称
	 */
	private String goodName;
	/**
	 * 该类商品数量
	 */
	private int number;
	/**
	 * 所属订单id
	 */
	private int orderId;
	/**
	 * 商品单价格
	 */
	private float price;
	/**
	 * 总价小结
	 */
	private int totalPrice;
	
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}