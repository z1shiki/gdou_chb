package gdou.gdou_chb.data.bean;

import java.io.Serializable;

/**
 * 商品分类
 * @author Administrator
 * @version 1.0
 * @updated 22-十一月-2016 20:16:36
 */

public class Classification extends BaseBean  implements Serializable {

	/**
	 * 分类名字
	 */
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}