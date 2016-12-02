package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.AddressModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class AddressModelImpl implements AddressModel {
    /**
     * 添加收货地址
     * @param address
     * @return
     */

    @Override
    public Observable<Result> addAddress(Address address) {
        HttpParams params = new HttpParams();
        params.put("address", String.valueOf(address));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.addAddress_URL
                ,params);
    }

    /**
     * 改变默认收货地址
     * @param addressId
     * @return
     */

    @Override
    public Observable<Result> changeDefault(long addressId) {
        HttpParams params = new HttpParams();
        params.put("addressId", String.valueOf(addressId));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.changeDefault_URL
                ,params);
    }

    /**
     * 删除地址
     * @param addressId
     * @return
     */

    @Override
    public Observable<Result> delete(long addressId) {
        HttpParams params = new HttpParams();
        params.put("addressId", String.valueOf(addressId));
        return RxVolleyUtils.getInstance().delete(
                BaseModelImpl.Service_URL +BaseModelImpl.delete_URL
                ,params);
    }

    /**
     * 获取所有收货地址
     * @param userId
     * @return
     */

    @Override
    public Observable<Result> all(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", String.valueOf(userId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.all_URL
                ,params);
    }

    /**
     * 默认地址
     * @param userId
     * @return
     */

    @Override
    public Observable<Result> defalut(long userId) {
        HttpParams params = new HttpParams();
        params.put("address", String.valueOf(userId));
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.defalut_URL
                ,params);
    }

    /**
     * 修改地址
     * @param address
     * @return
     */

    @Override
    public Observable<Result> update(Address address) {
        HttpParams params = new HttpParams();
        params.put("address", String.valueOf(address));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.updateAdderss_URL
                ,params);
    }
}

