package gdou.gdou_chb.model;

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
    void register(String account,String password,String verifyCode);

    /**
     * 登录
     * @param accout
     * @param password
     * @return
     */
    void doLogin(String accout,String password );

    /**
     * 忘记密码
     * @param account
     * @param password
     * @param verifyCode
     * @return
     */
    void resetPassword(String account,String password,String verifyCode);

    /**
     * 更改密码
     * @param oldPassword
     * @param id
     * @param newPassword
     * @return
     */
    void changePassword(String oldPassword, Long id, String newPassword);


    /**
     * 查找指定用户信息
     * @param userId
     * @return
     */
    void findUserInfo(Long userId );



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
    void update(String username,String realName,Long phone,
                Long loginId,Long userImg,Long safePassword );

}
