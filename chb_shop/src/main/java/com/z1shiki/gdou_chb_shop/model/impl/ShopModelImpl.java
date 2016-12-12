package com.z1shiki.gdou_chb_shop.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.model.ShopModel;
import com.z1shiki.gdou_chb_shop.util.RxVolleyUtils;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class ShopModelImpl implements ShopModel {
    @Override
    public Observable<Result> Shop() {
        HttpParams params  = new HttpParams();
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.shop_URL
                ,params);
    }
}
