package gdou.gdou_chb.model.bean;

import java.io.Serializable;

/**
 * Created by WT on 2016/11/29.
 */

public class User implements Serializable {
    /**
     * 用户ID
     */
    private long id;
    /**
     * 账户
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private long phone;

    private String userImage;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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


    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", username='" + username + '\'' +
                ", phone=" + phone +
                ", userImage='" + userImage + '\'' +
                '}';
    }
}

