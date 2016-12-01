package gdou.gdou_chb.data.bean;

import java.io.Serializable;


/**
 * 商家申请表
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:40
 */

public class ShopApply extends BaseBean implements Serializable {

	/**
	 * 身份证背面照
	 */
	private String identityBackImg;
	/**
	 * 身份证正面照
	 */
	private String identityImg;
	/**
	 * 1.申请认证中
	 * 2.认证通过
	 * 3.认证失败
	 * 4.拒绝再次认证
	 * 
	 * 3.认证失败后，用户可以再次申请认证，4，拒绝认证后，不再开放认证功能
	 */
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdentityBackImg() {
		return identityBackImg;
	}

	public void setIdentityBackImg(String identityBackImg) {
		this.identityBackImg = identityBackImg;
	}

	public String getIdentityImg() {
		return identityImg;
	}

	public void setIdentityImg(String identityImg) {
		this.identityImg = identityImg;
	}

	public ShopApply(){

	}

	public void finalize() throws Throwable {

	}

}