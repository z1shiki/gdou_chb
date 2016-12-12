package com.z1shiki.gdou_chb_shop.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 保存本地数据
 */
public class SPUtils {

    private static String TAG = "SPUtils";
    private static SharedPreferences
            sp_set = null,
            sp_user = null,
            sp_cache = null;
    /**设置数据*/
    private static String KEY_SET =  "setData";
    /**用户数据*/
    private static String KEY_USER = "userData";
    /**缓存数据*/
    private static String KEY_CACHE = "cacheData";


    /**
     * 初始化数据
     * @param mContext
     */
    public static void init(Context mContext) {
        if (sp_set == null || sp_user == null || sp_cache == null) {
            sp_set = mContext.getSharedPreferences(KEY_SET,Context.MODE_PRIVATE);
            sp_user = mContext.getSharedPreferences(KEY_USER,Context.MODE_PRIVATE);
            sp_cache = mContext.getSharedPreferences(KEY_CACHE,Context.MODE_PRIVATE);
        }
    }

    /**
     * 保存设置数据
     * @param context   Context
     * @param key       保存数据的密钥
     * @param value     保存数据
     */
    public static void putSetData(Context context,final String key, Object value) {
        if (null == sp_set) {
            init(context);
        }
        if (value instanceof String || value instanceof List || value instanceof Map) {
            sp_set.edit().putString(key, value.toString()).apply();
        } else if (value instanceof Boolean) {
            sp_set.edit().putBoolean(key,(Boolean) value).apply();
        } else if (value instanceof Integer) {
            sp_set.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Long) {
            sp_set.edit().putLong(key, (Long) value).apply();
        } else if (value instanceof Float) {
            sp_set.edit().putFloat(key, (Float) value).apply();
        } else {
            Log.e(TAG, "保存数据类型错误。。。。");
        }
    }

    /**
     * 保存设置数据
     * @param key  数据的密钥
     * @param value 保存的数据
     */
    public static void putSetData(String key, Object value) {
        putSetData(null, key, value);
    }


    /**
     * 保存用户数据
     * @param context   Context
     * @param key       保存数据的密钥
     * @param value     保存数据
     */
    public static void putUserData(Context context,final String key, Object value) {
        if (null == sp_user) {
            init(context);
        }
        if (value instanceof String || value instanceof List || value instanceof Map) {
            sp_user.edit().putString(key, value.toString()).apply();
        } else if (value instanceof Boolean) {
            sp_user.edit().putBoolean(key,(Boolean) value).apply();
        } else if (value instanceof Integer) {
            sp_user.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Long) {
            sp_user.edit().putLong(key, (Long) value).apply();
        } else if (value instanceof Float) {
            sp_user.edit().putFloat(key, (Float) value).apply();
        } else {
            Log.e(TAG, "保存数据类型错误。。。。");
        }
    }

    /**
     * 保存用户数据
     * @param key  数据的密钥
     * @param value 保存的数据
     */
    public static void putUserData(String key, Object value) {
        putUserData(null, key, value);
    }

    /**
     * 保存缓存数据
     * @param context   Context
     * @param key       保存数据的密钥
     * @param value     保存数据
     */
    public static void putCacheData(Context context,final String key, Object value) {
        if (null == sp_cache) {
            init(context);
        }
        if (value instanceof String || value instanceof List || value instanceof Map) {
            sp_cache.edit().putString(key, value.toString()).apply();
        } else if (value instanceof Boolean) {
            sp_cache.edit().putBoolean(key,(Boolean) value).apply();
        } else if (value instanceof Integer) {
            sp_cache.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Long) {
            sp_cache.edit().putLong(key, (Long) value).apply();
        } else if (value instanceof Float) {
            sp_cache.edit().putFloat(key, (Float) value).apply();
        } else {
            Log.e(TAG, "保存数据类型错误。。。。");
        }
    }

    /**
     * 保存设置数据
     * @param key  数据的密钥
     * @param value 保存的数据
     */
    public static void putCacheData(String key, Object value) {
        putCacheData(null, key, value);
    }

    /**
     * 删除指定的设置数据
     * @param key
     */
    public static void RemoveSetData(final String key) {
        sp_set.edit().remove(key);
    }

    /**
     * 删除指定的用户数据
     * @param key
     */
    public static void RemoveUserData(final String key) {
        sp_user.edit().remove(key);
    }

    /**
     * 删除指定的缓存数据
     * @param key
     */
    public static void RemoveCacheData(final String key) {
        sp_cache.edit().remove(key);
    }

    /**
     * 删除设置数据
     */
    public static void ClearSetData() {
        sp_set.edit().clear().apply();
    }

    /**
     * 删除用户数据
     */
    public static void ClearUserData() {
        sp_user.edit().clear().apply();
    }

    /**
     * 删除缓存数据
     */
    public static void ClearCacheData() {
        sp_cache.edit().clear().apply();
    }


    /**
     * 删除所有的数据
     */
    public static void ClearAllData() {
        ClearCacheData();
        ClearSetData();
        ClearUserData();
    }
    /**
     *  获取缓存 SharePreferences
     * @return  sp_cache SharedPreferences
     */
    public static SharedPreferences getSp_cache() {
        return sp_cache;
    }

    /**
     *  获取设置 SharePreferences
     * @return  sp_set SharedPreferences
     */
    public static SharedPreferences getSp_set() {
        return sp_set;
    }

    /**
     *  获取用户 SharePreferences
     * @return  sp_user SharedPreferences
     */
    public static SharedPreferences getSp_user() {
        return sp_user;
    }

    /**
     * 反序列化
     * @param key
     * @param defValue
     * @param <C>
     * @return
     */
    public static <C extends Serializable> C getObject(String key, C defValue) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        C result = defValue;

        String value = sp_user.getString(key, null);
        if (value != null) {
            try {
                byte[] decoded = Base64.decode(value.getBytes(), Base64.DEFAULT);
                bais = new ByteArrayInputStream(decoded);
                ois = new ObjectInputStream(bais);
                result = (C) ois.readObject();

            } catch (Exception e) {
                Log.e(TAG, e.toString());

            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    }
                }
                if (bais != null) {
                    try {
                        bais.close();
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                    }
                }
            }
        }
        return result;
    }

    /**
     * 本地序列化
     * @param key
     * @param value
     * @param <C>
     */
    public static <C extends Serializable> void putObject(String key, C value) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(value);
            byte[] encoded = Base64.encode(baos.toByteArray(), Base64.DEFAULT);
            sp_user.edit().putString(key, new String(encoded)).apply();

        } catch (IOException e) {
            Log.e(TAG, e.toString());
            throw new RuntimeException(e);

        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
    }
}

