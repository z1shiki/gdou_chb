package gdou.gdou_chb.model;


import gdou.gdou_chb.data.bean.Goods;

/**
 * Created by WT on 2016/11/30.
 */

public interface GoodModel {

    /**
     * 通过商品ID查询商品
     * @param goodsId 商品ID
     * @return
     */
    Goods findByGoodsId(Long goodsId);
}

