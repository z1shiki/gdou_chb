package gdou.gdou_chb.model.impl;

import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.model.UserModel;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class UserModelImpl implements UserModel {
    @Override
    public void register(String account, String password, String verifyCode) {

    }

    @Override
    public void doLogin(String accout, String password) {

    }

    public Observable<User> login(User user) {
        return Observable.just(user);
    }

    @Override
    public void resetPassword(String account, String password, String verifyCode) {

    }

    @Override
    public void changePassword(String oldPassword, Long id, String newPassword) {

    }

    @Override
    public void findUserInfo(Long userId) {

    }

    @Override
    public void update(String username, String realName, Long phone, Long loginId, Long userImg, Long safePassword) {

    }
}
