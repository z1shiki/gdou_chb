package gdou.gdou_chb.model;

/**
 * Created by WT on 2016/11/30.
 */

public interface VerifycodeModel{
    /**
     * 获取验证码
     * @param phoneNumber
     */
     void getVerifycode(String phoneNumber);
}
