package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.ShopModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class ShopModelImpl implements ShopModel {
    /**
     * 商店列表
     * @param userId
     * @return
     */
    @Override
    public Observable<Result> Shop(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", String.valueOf(userId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.shop_URL
                ,params);
    }

    /**
     * 营业
     * @param userId
     * @return
     */

    @Override
    public Observable<Result> Online(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", String.valueOf(userId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.OnLine_URL
                ,params);
    }

    /**
     * 停业
     * @param userId
     * @return
     */

    @Override
    public Observable<Result> OffLine(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", String.valueOf(userId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.OffLine_URL
                ,params);
    }
}
