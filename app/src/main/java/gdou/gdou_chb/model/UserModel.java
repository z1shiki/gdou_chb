package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.model.bean.User;
import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */
public interface UserModel {
    /**
     * 用户注册
     * @param user
     * @param verifyCode
     * @return
     */
    Observable<Result> register(User user, String verifyCode);
    /**
     * 登录
     * @param user
     * @return
     */
    Observable<Result> doLogin(User user );
    /**
     * 忘记密码
     * @param user
     * @param verifyCode
     * @return
     */
    Observable<Result> resetPassword(User user,String verifyCode);
    /**
     * 更改密码
     * @param user
     * @return
     */
    Observable<Result> changePassword(User user);
    /**
     * 更改手机
     * @param user
     * @return
     */
    Observable<Result> changePhone(User user);
    /**
     * 修改头像
     * @param user
     * @return
     */
    Observable<Result> changeUserImg(User user);
    /**
     * 查找指定用户信息
     * @param user
     * @return
     */
    Observable<Result> findUserInfo(User user );
}
