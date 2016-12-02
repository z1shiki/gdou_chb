package gdou.gdou_chb.model;

import com.kymjs.rxvolley.rx.Result;

import rx.Observable;

/**
 * Created by WT on 2016/11/30.
 */

public interface VerifycodeModel{
    /**
     * 获取验证码
     * @param phoneNumber
     */
    Observable<Result> getVerifycode(String phoneNumber);
}
