package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * Created by WT on 2016/11/29.
 */

public class User extends BaseBean implements Serializable {

    /**
     * 登录账号
     */
    private String account;
    /**
     * 是否禁用 冻结用户
     */
    private boolean enable;

    /**
     * 密码
     */
    private String password;
    /**
     * 加密盐
     */
    private String salt;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public boolean isEnable() {
        return enable;
    }

    /**
     * @param account account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @param enable enable
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param salt salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
}

