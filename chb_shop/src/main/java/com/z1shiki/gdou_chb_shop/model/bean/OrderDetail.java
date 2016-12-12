package com.z1shiki.gdou_chb_shop.model.bean;

import java.io.Serializable;

/**
 * 订单详情
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:38
 */
public class OrderDetail implements Serializable{

	private Integer id;
	
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
	private float totalPrice;
	
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
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderDetail[" +
				"id=" + id +
				", goodName='" + goodName + '\'' +
				", number=" + number +
				", orderId=" + orderId +
				", price=" + price +
				", totalPrice=" + totalPrice +
				']';
	}
}