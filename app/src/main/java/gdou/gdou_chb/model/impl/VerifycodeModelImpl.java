package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.VerifycodeModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class VerifycodeModelImpl implements VerifycodeModel {

    @Override
    public Observable<Result> getVerifycode(String phoneNumber) {
        HttpParams params = new HttpParams();
        params.put("phoneNumber", phoneNumber);
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL + BaseModelImpl.getVerifycode_URL
                ,params);
    }
}
