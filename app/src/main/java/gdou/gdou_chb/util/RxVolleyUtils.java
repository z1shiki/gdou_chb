package gdou.gdou_chb.util;

import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import com.kymjs.rxvolley.RxVolley;


/**
 * RxVoller的工具类
 */
public class RxVolleyUtils {


    private static RxVolleyUtils rxVolleyUtils;

    private  HttpParams params;
    private  String url;
    private  HttpCallback callback;

    /**
     * 单例
     * @return RxVolleyUtils
     */
    public static RxVolleyUtils getInstance() {
        return null == rxVolleyUtils? new RxVolleyUtils() : rxVolleyUtils;
    }

    private RxVolleyUtils(){

    }


    /**
     *不带缓存的Get请求
     * @param url  请求路径
     * @param params  请求参数
     * @param callback  回调函数
     */
    public void get(String url, HttpParams params, HttpCallback callback) {

        if (null == params) {
            params = new HttpParams();
        }
        this.url = url;
        this.params = params;
        this.callback = callback;

        new RxVolley
                .Builder()
                .params(params)
                .url(url)
                .httpMethod(RxVolley.Method.GET)
                .callback(callback)
                .shouldCache(false)
                .timeout(5000)
                .doTask();
    }


    /**
     *Post请求
     * @param url  请求路径
     * @param params  请求参数
     * @param callback  回调函数
     */
    public void post(String url, HttpParams params, HttpCallback callback) {
        if (null == params) {
            params = new HttpParams();
        }
        this.url = url;
        this.params = params;
        this.callback = callback;
        new RxVolley
                .Builder()
                .params(params)
                .httpMethod(RxVolley.Method.POST)
                .url(url)
                .callback(callback)
                .shouldCache(false)
                .timeout(5000)
                .doTask();
    }

    /**
     *Post  Json请求
     * @param url  请求路径
     * @param params  请求参数
     * @param callback  回调函数
     */
    public void postJson(String url, HttpParams params, HttpCallback callback) {

        if (null == params) {
            params = new HttpParams();
        }
        this.url = url;
        this.params = params;
        this.callback = callback;

        new RxVolley
                .Builder()
                .params(params)
                .httpMethod(RxVolley.Method.POST)
                .url(url)
                .contentType(RxVolley.ContentType.JSON)
                .callback(callback)
                .shouldCache(false)
                .timeout(5000)
                .doTask();
    }

}

