package com.z1shiki.gdou_chb_shop.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;
import com.z1shiki.gdou_chb_shop.model.UserModel;
import com.z1shiki.gdou_chb_shop.model.bean.User;
import com.z1shiki.gdou_chb_shop.util.RxVolleyUtils;

import java.io.File;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class UserModelImpl extends BaseModelImpl implements UserModel {
    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    @Override
    public Observable<Result> register(User user, String verifyCode) {
        HttpParams params = new HttpParams();
        params.put("account",user.getAccount());
        params.put("password",user.getPassword());
        params.put("verifyCode",verifyCode);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.register_URL
                ,params);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public Observable<Result> doLogin(User user) {
        HttpParams params  = new HttpParams();
        params.put("account",user.getAccount());
        params.put("password",user.getPassword());
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.doLogin_URL
                ,params);
    }

    /**
     * 忘记密码
     * @param user
     * @param verifyCode
     * @return
     */
    @Override
    public Observable<Result> resetPassword(User user, String verifyCode) {
        HttpParams params  = new HttpParams();
        params.put("account",user.getAccount());
        params.put("password",user.getPassword());
        params.put("verifyCode",verifyCode);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.resetPassword_URL
                ,params);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Override
    public Observable<Result> changePassword(User user) {
        HttpParams params  = new HttpParams();
        params.put("oldPassword",user.getAccount());
        params.put("id", String.valueOf(user.getId()));
        params.put("newPassword",user.getNewPassword());
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.changePassword_URL
                ,params);
    }



    /**
     * 修改手机号
     * @param user
     * @return
     */
    @Override
    public Observable<Result> changePhone(User user, String verifyCode) {
        HttpParams params  = new HttpParams();
        params.put("phone", String.valueOf(user.getPhone()));
        params.put("id", String.valueOf(user.getId()));
        params.put("verifyCode",verifyCode);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.updateUser_URL
                ,params);
    }

    /**
     * 修改头像
     * @param user
     * @return
     */
    @Override
    public Observable<Result> changeUserImg(User user) {
        HttpParams params  = new HttpParams();
        //TODO 上次用户头像
        params.put("file", new File("dddd"));
        params.put("id", String.valueOf(user.getId()));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.updateUser_URL
                ,params);
    }

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    @Override
    public Observable<Result> findUserInfo(User user) {
        HttpParams params  = new HttpParams();
        params.put("findUserInfo", String.valueOf(user.getId()));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL + BaseModelImpl.findUserInfo_URL
                ,params);
    }
}