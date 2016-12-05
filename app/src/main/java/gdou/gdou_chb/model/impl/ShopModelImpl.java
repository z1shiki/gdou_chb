package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.ShopModel;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class ShopModelImpl implements ShopModel {
    @Override
    public Observable<Result> Shop(Shop shop) {
        return null;
    }

    @Override
    public Observable<Result> OpenTime(Shop shop) {
        return null;
    }

    @Override
    public Observable<Result> StopTime(Shop shop) {
        return null;
    }
}
