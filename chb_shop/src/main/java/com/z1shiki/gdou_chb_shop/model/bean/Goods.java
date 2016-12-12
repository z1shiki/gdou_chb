package com.z1shiki.gdou_chb_shop.model.bean;

import java.io.Serializable;

/**
 * 商品基本信息
 * Created by WT on 2016/11/29.
 */

public class Goods implements Serializable {
    /**
     * 商品Id
     */
    private long id;
    /**
     * 商品名字
     */
    private String name;
    /**
     * 商品数量
     */
    private long number;
    /**
     * 商品单价
     */
    private long price;


    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}