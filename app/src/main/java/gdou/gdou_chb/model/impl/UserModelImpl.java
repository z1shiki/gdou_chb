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

public class UserModelImpl implements UserModel {
    @Override
    public void register(String account, String password, String verifyCode) {

    }

    @Override
    public void doLogin(String accout, String password) {

    }

    public Observable<Result> doLogin1(User user){
        HttpParams params = new HttpParams();
        params.put("account",user.getAccount());
        params.put("password",user.getPassword());

//        HttpCallback callback =new HttpCallback() {
//            @Override
//            public void onSuccess(String t) {
//                super.onSuccess(t);
//            }
//
//            @Override
//            public void onFailure(int errorNo, String strMsg) {
//                super.onFailure(errorNo, strMsg);
//            }
//        };

        return RxVolleyUtils.getInstance().post(
                "172.16.15.215:9001/users/doLogin"
                ,params);
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
