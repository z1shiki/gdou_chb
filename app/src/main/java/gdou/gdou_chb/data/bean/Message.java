package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 系统消息
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:37
 */

public class Message  implements Serializable{

	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 接受者id
	 */
	private Long userId;
	 
	/**
	 * 是否已读
	 */
	private boolean isRead;
	
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}