package gdou.gdou_chb.model.impl;

import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.UserModel;
import gdou.gdou_chb.util.RxVolleyUtils;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public class UserModelImpl extends BaseModelImpl implements UserModel {
    /**
     * 注册
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */
    @Override
    public Observable<Result> register(String account,String password, String verifyCode) {
        HttpParams params = new HttpParams();
        params.put("account",account);
        params.put("password",password);
        params.put("verifycode",verifyCode);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.register_URL
                ,params);
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */

    @Override
    public Observable<Result> doLogin(String account,String password) {
        HttpParams params = new HttpParams();
        params.put("account",account);
        params.put("password",password);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.doLogin_URL
                ,params);
    }

    /**
     * 忘记密码
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */

    @Override
    public Observable<Result> resetPassword(String account, String password, String verifyCode) {
        HttpParams params = new HttpParams();
        params.put("account",account);
        params.put("password",password);
        params.put("veifyConde",verifyCode);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.resetPassword_URL
                ,params);
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param id
     * @param newPassword
     * @return
     */

    @Override
    public Observable<Result> changePassword(String oldPassword, Long id, String newPassword) {
        HttpParams params = new HttpParams();
        params.put("oldPassword",oldPassword);
        params.put("id", String.valueOf(id));
        params.put("newPassword",newPassword);
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.changePassword_URL
                ,params);
    }

    /**
     * 用户信息
     * @param userId
     * @return
     */

    @Override
    public Observable<Result> findUserInfo(Long userId) {
        HttpParams params = new HttpParams();
        params.put("userId", String.valueOf(userId));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.findUserInfo_URL
                ,params);
    }

    /**
     * 更新用户信息
     * @param username
     * @param realName
     * @param phone
     * @param loginId
     * @param userImg
     * @param safePassword
     * @return
     */

    @Override
    public Observable<Result> update(String username, String realName,
                                     Long phone, Long loginId, Long userImg, Long safePassword) {
        HttpParams params = new HttpParams();
        params.put("username", username);
        params.put("realName",realName);
        params.put("phone", String.valueOf(phone));
        params.put("loginId", String.valueOf(loginId));
        params.put("userImg",String.valueOf(userImg));
        params.put("safePassword", String.valueOf(safePassword));
        return RxVolleyUtils.getInstance().post(
                BaseModelImpl.Service_URL +BaseModelImpl.updateUser_URL
                ,params);
    }
}
