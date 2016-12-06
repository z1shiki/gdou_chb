package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.UserModel;
import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class UserModelImpl extends BaseModelImpl implements UserModel {
    @Override
    public Observable<Result> register(User user, String verifyCode) {
        return null;
    }

    @Override
    public Observable<Result> doLogin(User user) {
        return null;
    }

    @Override
    public Observable<Result> resetPassword(User user, String verifyCode) {
        return null;
    }

    @Override
    public Observable<Result> changePassword(User user) {
        return null;
    }

    @Override
    public Observable<Result> changePhone(User user) {
        return null;
    }

    @Override
    public Observable<Result> changeUserImg(User user) {
        return null;
    }

    @Override
    public Observable<Result> findUserInfo(User user) {
        return null;
    }
}