package gdou.gdou_chb.data.bean;

import java.io.Serializable;


/**
 * 用户信息
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:41
 */

public class UserInfo  implements Serializable {

	/**
	 * 用户真实姓名
	 */
	private String realName;
	/**
	 * 用户头像
	 */
	private String userImg;
	/**
	 * 用户昵名
	 */
	private String username;
	
	/**
	 * 关联账号信息
	 */
	private long userId;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}