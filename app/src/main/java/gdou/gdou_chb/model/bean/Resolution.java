package gdou.gdou_chb.model.bean;

import java.io.Serializable;


/**
 * 常见问题解决
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:21:21
 */

public class Resolution extends BaseBean implements Serializable{
	/**
	 * 回答
	 */
	private String answer;
	/**
	 * 问题
	 */
	private String question;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}



}