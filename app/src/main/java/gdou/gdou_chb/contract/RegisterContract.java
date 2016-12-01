package gdou.gdou_chb.contract;

import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.util.MVP.BasePresenter;
import gdou.gdou_chb.util.MVP.BaseView;

/**
 * Created by Z1shiki on 2016/11/29.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter>{
        void waittingSend();
    }

    interface Presenter extends BasePresenter{
        void sentcode(int phonenumber);
        void register(User user);
    }

}