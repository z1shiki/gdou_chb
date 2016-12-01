package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 订单评论
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:37:06
 */

public class Comment extends BaseBean implements Serializable {
	
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 订单id
	 */
	private long orderId;
	/**
	 * 发送消息的用户
	 */
	private long froms;
	/**
	 * 接收消息的用户
	 */
	private long tos;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getFroms() {
		return froms;
	}

	public void setFroms(long froms) {
		this.froms = froms;
	}

	public long getTos() {
		return tos;
	}

	public void setTos(long tos) {
		this.tos = tos;
	}



}