package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Shop;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface ShopModel {
    /**
     * 商店列表
     * @param shop
     */
    Observable<Result> Shop(Shop shop);
    /**
     * 开店时间
     * @param shop
     * @return
     */
    Observable<Result> OpenTime(Shop shop);
    /**
     * 关店时间
     * @param shop
     * @return
     */
    Observable<Result> StopTime(Shop shop);
}
