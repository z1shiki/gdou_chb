package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.GoodModel;
import gdou.gdou_chb.model.bean.Goods;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class GoodModelImpl extends BaseModelImpl implements GoodModel {
    @Override
    public Observable<Result> findByGoodsId(Goods goods) {
        return null;
    }
}
