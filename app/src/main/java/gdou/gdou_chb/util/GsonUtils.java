package gdou.gdou_chb.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import gdou.gdou_chb.model.bean.BaseBean;
import gdou.gdou_chb.model.bean.ResultBean;

/**
 * Gson的工具类
 */
public class GsonUtils {

    private static Gson mGson;
    private static ResultBean resultBean;
    private static String key;
    private static Class<BaseBean[]> clazz;

    private GsonUtils() {

    }

    /**
     * 获取Gson的单例
     *
     * @return
     */
    public static Gson Instance() {
        if (null == mGson) {
            mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        }
        return mGson;
    }

    /**
     * Json转 实体类
     *
     * @param jsonStr  Json数据
     * @param baseBean extends BaseBean
     * @return <Class extends BaseBean></Class>
     */
    public static BaseBean getBean(String jsonStr, BaseBean baseBean) {
        if (null == jsonStr || jsonStr.equals(""))
            return null;
        BaseBean result = (BaseBean) Instance().fromJson(jsonStr, baseBean.getClass());
        return result;
    }

    /**
     * 对象转JSON
     *
     * @param object
     * @return String jsonStr 转型后的Json
     */
    public static String getJsonStr(Object object) {

        if (null == object)
            return null;

        String jsonStr = Instance().toJson(object);
        if (jsonStr != null)
            return jsonStr;
        return "";
    }

    /**
     * 获取返回的值
     *
     * @param resultBean
     * @param key
     * @param <T>
     * @return List<T></T>
     */
    public static <T extends BaseBean> List<T> getParams(ResultBean resultBean, String key, Class<T> clazz) {

        if(resultBean.getResultParam().isEmpty()){
            return null;
        }
        String tempStr = GsonUtils.Instance().toJson(resultBean.getResultParam().get(key));

        if (clazz != null && tempStr != null) {
            JsonArray array = new JsonParser().parse(tempStr).getAsJsonArray();
            List<T> resultList = new ArrayList<T>();
            for (final JsonElement elem : array) {
                resultList.add(GsonUtils.Instance().fromJson(elem, clazz));
            }
            if (resultList == null && resultList.size() != 0) {
                return null;
            }
            return resultList;
        } else {
            return null;
        }
    }

    /**
     * 获取返回的值
     *
     * @param resultBean
     * @param key
     * @param <T>
     * @return T</T>
     */
    public static <T extends BaseBean> T getParam(ResultBean resultBean, String key, Class<T> clazz) {
        String tempStr = GsonUtils.Instance().toJson(resultBean.getResultParam().get(key));
        T result = GsonUtils.Instance().fromJson(tempStr, clazz);
        return result;
    }

    /**
     * 获取ResultBean
     *
     * @param t
     * @return
     */
    public static ResultBean getResultBean(String t) {
        if (null == t || t.equals(""))
            return null;
        ResultBean resultBean = GsonUtils.Instance().fromJson(t, ResultBean.class);
        return resultBean;
    }
}

