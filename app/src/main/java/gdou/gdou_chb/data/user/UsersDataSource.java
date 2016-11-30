package gdou.gdou_chb.data.user;

import gdou.gdou_chb.data.bean.User;
import rx.Observable;

/**
 * Created by Z1shiki on 2016/11/22.
 */

public interface UsersDataSource{
    Observable<User> login(User user);
    void mRememberUser(String username);
    String getReUsername();
}
