package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public interface UserModel {

    /**
     * 用户注册
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */
    Observable<Result> register(String account, String password, String verifyCode);

    /**
     * 登录
     * @param accout
     * @param password
     * @return
     */
    Observable<Result> doLogin(String accout,String password );

    /**
     * 忘记密码
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */
    Observable<Result> resetPassword(String account,String password,String verifyCode);

    /**
     * 更改密码
     * @param oldPassword
     * @param id
     * @param newPassword
     * @return
     */
    Observable<Result> changePassword(String oldPassword, Long id, String newPassword);


    /**
     * 查找指定用户信息
     * @param userId
     * @return
     */
    Observable<Result> findUserInfo(Long userId );



    /**
     * 更新信息
     * @param username
     * @param realName
     * @param phone
     * @param loginId
     * @param userImg
     * @param safePassword
     * @return
     */
    Observable<Result> update(String username,String realName,Long phone,
                Long loginId,Long userImg,Long safePassword );

}
