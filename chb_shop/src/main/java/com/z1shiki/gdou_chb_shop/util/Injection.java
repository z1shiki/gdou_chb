package com.z1shiki.gdou_chb_shop.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.z1shiki.gdou_chb_shop.model.impl.UserModelImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Z1shiki on 2016/11/23.
 * 对Model的注入
 */

public class Injection {
    public static UserModelImpl provideUsersModel(@NonNull Context context){
        checkNotNull(context);
        return new UserModelImpl();
    }
}
