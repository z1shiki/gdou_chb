package gdou.gdou_chb.model;

import com.kymjs.rxvolley.client.HttpCallback;

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
    void findByGoodsId(Long goodsId, HttpCallback callback);
}

