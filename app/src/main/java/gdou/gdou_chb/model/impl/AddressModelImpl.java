package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.AddressModel;
import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class AddressModelImpl implements AddressModel {
    @Override
    public Observable<Result> addAddress(Address address) {
        return null;
    }

    @Override
    public Observable<Result> changeDefault(Address address) {
        HttpParams params = new HttpParams();
        //params.put("address", address.getAddress());
        //params.put("latitude", String.valueOf(address.getLatitude()));
        //params.put("longitude",String.valueOf(address.getLongitude()));
        //params.put("userId",user.getUserId());
        //params.put("phone",);
        return RxVolleyUtils.getInstance().post(
        BaseModelImpl.Service_URL +BaseModelImpl.addAddress_URL
         ,params);
    }

    @Override
    public Observable<Result> delete(Address address) {
        return null;
    }

    @Override
    public Observable<Result> all(User user) {
        return null;
    }

    @Override
    public Observable<Result> defalut(User user) {
        return null;
    }

    @Override
    public Observable<Result> update(Address address) {
        return null;
    }
}