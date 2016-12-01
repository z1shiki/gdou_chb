package gdou.gdou_chb.model.bean;

import java.util.Map;

/**
 * 请求结果封装类
 * Created by WT on 2016/12/1.
 *
 */

public class ResultBean extends BaseBean {
    //请求识别标
    private boolean serviceResult;
    //请求结果信息
    private String resultInfo;
    //请求数据
    private Map<String, Object> resultParam;
    private boolean userToken;

    public boolean isServiceResult() {
        return serviceResult;
    }

    public void setServiceResult(boolean serviceResult) {
        this.serviceResult = serviceResult;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Map<String, Object> getResultParam() {
        return resultParam;
    }

    public void setResultParam(Map<String, Object> resultParam) {
        this.resultParam = resultParam;
    }

    public boolean isUserToken() {
        return userToken;
    }

    public void setUserToken(boolean userToken) {
        this.userToken = userToken;
    }
}


