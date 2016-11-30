package gdou.gdou_chb.data.user;


import android.support.annotation.NonNull;

import gdou.gdou_chb.data.bean.User;
import rx.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Z1shiki on 2016/11/22.
 * 数据库的具体实现，在本地存放一个副本,数据库的操作封装尚未完成
 */

public class UsersRepository implements UsersDataSource{
    private final UsersDataSource mUsersOnlineDataSource;
    private final UsersDataSource mUserslocalDataSource;
    boolean mCachelsIsDirty = false;

    public UsersRepository() {
        mUserslocalDataSource = null;
        mUsersOnlineDataSource = null;
    }

    public UsersRepository(UsersDataSource usersOnlineDataSource, UsersDataSource userslocalDataSource) {
        mUsersOnlineDataSource = checkNotNull(usersOnlineDataSource);
        mUserslocalDataSource = checkNotNull(userslocalDataSource);
    }

    @Override
    public Observable<User> login(@NonNull User mUser){
            //发送User到网络请求，等待返回值
        return Observable.just(mUser);
    }

    @Override
    public void mRememberUser(String username) {

    }

    @Override
    public String getReUsername() {
        return null;
    }
}
