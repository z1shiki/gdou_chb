package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 商家信息
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:40
 */

public class Shopper extends BaseBean implements Serializable{
	/**
	 * 商家简介
	 */
	private String introduction;
	
	private String address;
	/**
	 * 联系方式
	 */
	private String contact;
	/**
	 * 身份证背面照
	 */
	private int identityBackImg;
	/**
	 * 身份证正面照
	 */
	private int identityImg;
	/**
	 * 当业务需求如下
	 * 
	 * 商家被冻结后，还能够用户身份登录系统
	 */
	private int status;
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getIdentityBackImg() {
		return identityBackImg;
	}
	public void setIdentityBackImg(int identityBackImg) {
		this.identityBackImg = identityBackImg;
	}
	public int getIdentityImg() {
		return identityImg;
	}
	public void setIdentityImg(int identityImg) {
		this.identityImg = identityImg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
