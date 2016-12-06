package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * Created by WT on 2016/11/29.
 */

public class User implements Serializable {
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private long phone;
    /**
     * 头像
     */
    private long userImg;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getUserImg() {
        return userImg;
    }

    public void setUserImg(long userImg) {
        this.userImg = userImg;
    }
}

