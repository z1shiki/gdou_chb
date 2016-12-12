package com.z1shiki.gdou_chb_shop.model.bean;

/**
 * Created by WT on 2016/12/7.
 * 用来交互数据的VO
 */

public class GoodsVo {

    /**
     * 商品id
     */
    private Integer id;
    /**
     * 数量
     */
    private Integer number;

    public GoodsVo(int id, int number) {
        this.id = id;
        this.number = number;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
