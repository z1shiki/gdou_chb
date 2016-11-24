package gdou.gdou_chb.util;

import android.content.Context;
import android.support.annotation.NonNull;

import gdou.gdou_chb.data.user.UsersRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Z1shiki on 2016/11/23.
 * 对Model的注入
 */

public class Injection {
    public static UsersRepository provideUsersRepository(@NonNull Context context){
        checkNotNull(context);
        return new UsersRepository();
    }
}
