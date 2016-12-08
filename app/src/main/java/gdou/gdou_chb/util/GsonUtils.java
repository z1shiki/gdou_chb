package gdou.gdou_chb.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gdou.gdou_chb.model.bean.ResultBean;


/**
 * Gson的工具类
 */
public class GsonUtils {

    private static final Gson gson = new Gson();
    /**
     * 将Json数据解析成相应的映射对象
     */
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        T result = gson.fromJson(jsonData, type);
        return result;
    }

    /**
     * 直接获取ResultBean
     * @param jsonStr
     * @return
     */
    public static ResultBean getResultBeanByJson(String jsonStr) {
        return parseJsonWithGson(jsonStr, ResultBean.class);
    }

    /**
     * 获取ResultBean中的实体
     * @param resultBean
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanFromResultBean(ResultBean resultBean, String key, Class<T> clazz) {
        return parseJsonWithGson(resultBean.getResultParm().get(key).toString(), clazz);
    }

    /**
     * 获取直接通过JsonStr  获取Bean
    * @param jsonStr
     * @param key
     * @param clazz
     * @param <T>
    * @return
     */
    public static <T> T getBeanFromResultStr(String jsonStr, String key, Class<T> clazz) {
        return getBeanFromResultBean(getResultBeanByJson(jsonStr), key, clazz);
    }

    /**
     * 获取ResultBean中的实体列表
     * @param resultBean
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getBeanFromResultBeanList(ResultBean resultBean, String key, Class<T> clazz) {
        return parseJsonArrayWithGson(resultBean.getResultParm().get(key).toString(), clazz);
    }

    public static <T> List<T> getBeanFromResultBeanListMiss(ResultBean resultBean, String key, Class<T[]> clazz) {

        if (null != resultBean.getResultParm().get(key)) {
            String jsonStr = resultBean.getResultParm().get(key).toString();
            Log.d("jsonStr", "getBeanFromResultBeanListMiss: " + jsonStr);
            return stringToArray(resultBean.getResultParm().get(key).toString(), clazz);
        }
        return null;
    }
    /**
     * 将Json数组解析成相应的映射对象列表
     */
    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        List<T> result = gson.fromJson(jsonData,  new TypeToken<ArrayList<T>>(){}.getType());
        return result;
    }


    /**
     * 获取ArrayList
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToArray(String jsonStr, Class<T[]> clazz) {
        return Arrays.asList(gson.fromJson(jsonStr, clazz));
    }

    /**
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonList(List<T> list, String json, Class<T> cls) {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        Log.d("Gson -> result", "fromJsonList: " + list.size());
        Log.d("Gosn -> List", "fromJsonList: " + GsonUtils.getJsonStr(list));
        return list;
    }
    /**
     * 对象转JSON
     */
    public static String getJsonStr(Object object) {

        if (null == object)
            return null;
        String jsonStr = gson.toJson(object);
        if (jsonStr != null)
            return jsonStr;
        return "";
    }
}
