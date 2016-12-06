package gdou.gdou_chb.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/**
 * Gson的工具类
 */
public class GsonUtils {
    /**
     * 将Json数据解析成相应的映射对象
     */
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
    /**
     * 将Json数组解析成相应的映射对象列表
     */
    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }
    /**
     * 对象转JSON
     */
    public static String getJsonStr(Object object) {

        if (null == object)
            return null;

        String jsonStr = new Gson().toJson(object);
        if (jsonStr != null)
            return jsonStr;
        return "";
    }
}
