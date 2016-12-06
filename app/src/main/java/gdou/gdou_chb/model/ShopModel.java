package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Shop;
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
