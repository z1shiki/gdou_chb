package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * 商品基本信息
 * @author Administrator
 * @version 1.0
 * @created 23-十一月-2016 16:59:43
 */

public class Goods  implements Serializable {


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    /**
     * 商品
     */
    private long Id;
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
	private String goodImg;
	/**
	 * 商品简介
	 */
	private String introduce;
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
	private float price;
	/**
	 * 1->商家上架 2->商家下架 3->后台管理员下架
	 */
	private int status;
	/**
	 * 商品是否已经审查
	 */
	private boolean watch;

	/**
	 * 商家Id
	 */
	private long shopId;

	/**
	 * 商品名
	 */
	private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getShopId() {
		return shopId;
	}


	public void setShopId(long shopId) {
		this.shopId = shopId;
	}


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


	/**
	 * Getter for property 'classification'.
	 *
	 * @return Value for property 'classification'.
	 */
	public long getClassification() {
		return classification;
	}

	/**
	 * Setter for property 'classification'.
	 *
	 * @param classification Value to set for property 'classification'.
	 */
	public void setClassification(long classification) {
		this.classification = classification;
	}

	/**
	 * Getter for property 'defNumber'.
	 *
	 * @return Value for property 'defNumber'.
	 */
	public int getDefNumber() {
		return defNumber;
	}

	/**
	 * Setter for property 'defNumber'.
	 *
	 * @param defNumber Value to set for property 'defNumber'.
	 */
	public void setDefNumber(int defNumber) {
		this.defNumber = defNumber;
	}

	/**
	 * Getter for property 'goodImg'.
	 *
	 * @return Value for property 'goodImg'.
	 */
	public String getGoodImg() {
		return goodImg;
	}

	/**
	 * Setter for property 'goodImg'.
	 *
	 * @param goodImg Value to set for property 'goodImg'.
	 */
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}


	/**
	 * Getter for property 'introduce'.
	 *
	 * @return Value for property 'introduce'.
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * Setter for property 'introduce'.
	 *
	 * @param introduce Value to set for property 'introduce'.
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * Getter for property 'price'.
	 *
	 * @return Value for property 'price'.
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Setter for property 'price'.
	 *
	 * @param price Value to set for property 'price'.
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Getter for property 'status'.
	 *
	 * @return Value for property 'status'.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Setter for property 'status'.
	 *
	 * @param stus Value to set for property 'stat
	 */
	public void setStatus(int stus) {
		this.status = status;
	}

    @Override
    public String toString() {
        return "Goods{" +
                "Id=" + Id +
                ", classification=" + classification +
                ", defNumber=" + defNumber +
                ", goodImg='" + goodImg + '\'' +
                ", introduce='" + introduce + '\'' +
                ", inUse=" + inUse +
                ", number=" + number +
                ", pass=" + pass +
                ", price=" + price +
                ", status=" + status +
                ", watch=" + watch +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                '}';
    }
}