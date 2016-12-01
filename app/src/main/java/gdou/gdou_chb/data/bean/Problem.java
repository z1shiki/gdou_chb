package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 问题反馈
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:21:24
 */

public class Problem extends BaseBean implements Serializable {
	
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 标题
	 */
	private String title;
	
	private long userId;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}