package com.z1shiki.gdou_chb_shop.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.model.AddressModel;
import com.z1shiki.gdou_chb_shop.model.bean.Address;
import com.z1shiki.gdou_chb_shop.util.RxVolleyUtils;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class AddressModelImpl implements AddressModel {
    @Override
    public Observable<Result> addAddress(Address address) {
        HttpParams params = new HttpParams();
        params.put("addressName", address.getAddressName());
        params.put("latitude", String.valueOf(address.getLatitude()));
        params.put("longitude",String.valueOf(address.getLongitude()));
        params.put("userId", address.getUserId() + "");
        params.put("phone", String.valueOf(address.getPhone()));
        params.put("name",address.getName());
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.addAddress_URL
                ,params);
    }

    @Override
    public Observable<Result> changeDefault(long addressId) {
        HttpParams params = new HttpParams();
        params.put("addressId", addressId + "");
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.updateAdderss_URL
                ,params);
    }

    @Override
    public Observable<Result> delete(long addressId) {
        HttpParams params = new HttpParams();
        params.put("addressId", addressId  + "");
        return RxVolleyUtils.getInstance().delete(
                BaseModelImpl.Service_URL +BaseModelImpl.delete_URL + addressId
                ,params);
    }

    @Override
    public Observable<Result> all(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", userId + "");
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.allUser_URL + userId
                ,params);
    }

    @Override
    public Observable<Result> defalut(long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", userId + "");
        return RxVolleyUtils.getInstance().get(
                BaseModelImpl.Service_URL +BaseModelImpl.defalut_URL + userId
                ,params);
    }

    @Override
    public Observable<Result> update(Address address) {
        HttpParams params = new HttpParams();
        params.put("addressId", String.valueOf(address.getId()));
        params.put("address", address.getAddressName());
        params.put("latitude", String.valueOf(address.getLatitude()));
        params.put("longitude",String.valueOf(address.getLongitude()));
        params.put("userId", String.valueOf(address.getUserId()));
        params.put("phone", String.valueOf(address.getPhone()));
        params.put("name",address.getName());
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.changeDefault_URL + address.getId()
                ,params);
    }
}