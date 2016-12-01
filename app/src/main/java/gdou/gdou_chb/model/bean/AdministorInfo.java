package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 管理员信息
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:35
 */

public class AdministorInfo  extends BaseBean implements Serializable {

	/**
	 * 标记账号信息，关联登录账号信息
	 */
	private Long userId;


	public Long getUserId(){
		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}

}