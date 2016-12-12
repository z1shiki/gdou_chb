package com.z1shiki.gdou_chb_shop.model;

import com.kymjs.rxvolley.rx.Result;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface ShopModel {
    /**
     * 商店列表，返回列表名称，开店和关店时间
     */
    Observable<Result> Shop();
}
