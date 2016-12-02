package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.GoodModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class GoodModelImpl extends BaseModelImpl implements GoodModel {
    /**
     * 商品
     * @param goodsId 商品ID
     * @return
     */
    @Override
    public Observable<Result> findByGoodsId(Long goodsId) {
            HttpParams params = new HttpParams();
            params.put("goodId",String.valueOf(goodsId));
            return RxVolleyUtils.getInstance().post(
                    BaseModelImpl.Service_URL + BaseModelImpl.findByGoodId_URL
                    ,params);
        }
    }
