package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.User;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface UserModel {
    /**
     * 用户注册,通过账号，密码，验证码
     * @param user
     * @param verifyCode
     * @return
     */
    Observable<Result> register(User user, String verifyCode);
    /**
     * 登录，通过账号，密码
     * @param user
     * @return
     */
    Observable<Result> doLogin(User user);
    /**
     * 忘记密码，通过账号，密码，验证码
     * @param user
     * @param verifyCode
     * @return
     */
    Observable<Result> resetPassword(User user, String verifyCode);
    /**
     * 更改密码，通过旧密码，用户Id，新密码
     * @param user
     * @return
     */
    Observable<Result> changePassword(User user);
    /**
     * 更改手机，通过账号，新手机，验证码
     * @param user
     * @return
     */
    Observable<Result> changePhone(User user, String verifyCode);
    /**
     * 修改头像，通过旧头像，用户Id，新头像
     * @param user
     * @return
     */
    Observable<Result> changeUserImg(User user);
    /**
     * 查找指定用户信息，通过用户Id
     * @param user
     * @return
     */
    Observable<Result> findUserInfo(User user);
}
