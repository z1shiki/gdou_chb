package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 商品基本信息
 * @author Administrator
 * @version 1.0
 * @created 23-十一月-2016 16:59:43
 */

public class Goods  extends BaseBean implements Serializable {

	/**
	 * 商品分类
	 */
	private long classification;
	/**
	 * 默认商品数量
	 */
	private int defNumber;
	/**
	 * 商品图片
	 */
	private int goodImg;
	/**
	 * 商品简介
	 */
	private int introduce;
	/**
	 * 是否上架
	 */
	private boolean inUse;
	/**
	 * 商品数量
	 */
	private int number;
	/**
	 * 添加商品是否通过
	 */
	private boolean pass;
	/**
	 * 商品单价
	 */
	private int price;
	/**
	 * 1->商家上架 2->商家下架 3->后台管理员下架
	 */
	private int status;
	/**
	 * 商品是否已经审查
	 */
	private boolean watch;

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}


	public int getNumber(){
		return number;
	}

	public boolean isInUse(){
		return inUse;
	}

	public boolean isPass(){
		return pass;
	}

	public boolean isWatch(){
		return watch;
	}

	/**
	 * 
	 * @param classification
	 */
	public void setClassification(int classification){
		this.classification = classification;
	}

	/**
	 * 
	 * @param inUse
	 */
	public void setInUse(boolean inUse){
		this.inUse = inUse;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(int number){
		this.number = number;
	}

	/**
	 * 
	 * @param pass
	 */
	public void setPass(boolean pass){
		this.pass = pass;
	}

	/**
	 * 
	 * @param watch
	 */
	public void setWatch(boolean watch){
		this.watch = watch;
	}

}