package com.z1shiki.gdou_chb_shop.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.model.GoodModel;
import com.z1shiki.gdou_chb_shop.util.RxVolleyUtils;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class GoodModelImpl extends BaseModelImpl implements GoodModel {
    @Override
    public Observable<Result> findByGoodsId(Long shopId) {
        HttpParams params  = new HttpParams();
        params.put("shop", String.valueOf(shopId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.findByShopId_URL + shopId
                ,params);
    }
}
