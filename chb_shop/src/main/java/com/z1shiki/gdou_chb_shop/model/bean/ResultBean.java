package com.z1shiki.gdou_chb_shop.model.bean;

import java.util.Map;

/**
 * 请求结果Bean
 * Created by WT on 2016/11/29.
 */
public class ResultBean {


    private boolean serviceResult;      //请求识别标

    private String resultInfo;          //请求结果

    private Map<String, Object> resultParm;          //请求响应数据结果


    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Map<String, Object> getResultParm() {
        return resultParm;
    }

    public void setResultParm(Map<String, Object> resultParm) {
        this.resultParm = resultParm;
    }

    public boolean isServiceResult() {
        return serviceResult;
    }

    public void setServiceResult(boolean serviceResult) {
        this.serviceResult = serviceResult;
    }

}
