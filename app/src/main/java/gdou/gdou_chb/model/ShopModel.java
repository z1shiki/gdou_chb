package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public interface ShopModel {
    /**
     * 商店列表
     * @param userId
     */
    Observable<Result> Shop(long userId);
    /**
     * 商家营业
     * @param userId
     * @return
     */
    Observable<Result> Online(long userId);

    /**
     * 商家休息
     * @param userId
     * @return
     */
    Observable<Result> OffLine(long userId);
}
