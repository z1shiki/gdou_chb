package gdou.gdou_chb.model;

import gdou.gdou_chb.data.bean.User;

/**
 * Created by WT on 2016/11/30.
 */

public interface UserModel {

    /**
     * 更改密码
     * @param oldPassword
     * @param id
     * @param newPassword
     * @return
     */
    User changePassword(String oldPassword, Long id, String newPassword) ;

    /**
     * 登录
     * @param accout
     * @param password
     * @return
     */
    User doLogin(String accout,String password);

    /**
     * 查找指定用户信息
     * @param userId
     * @return
     */
    User findUserInfo(Long userId);

    /**
     * 用户注册
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */
    User register(String account,String password,String verifyCode);

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
    User update(String username,String realName,Long phone,Long loginId,Long userImg,Long safePassword);
}
