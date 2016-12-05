package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Goods;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface GoodModel {
    /**
     * 查询商品
     * @param goods
     * @return
     */
    Observable<Result> findByGoodsId(Goods goods);
}

