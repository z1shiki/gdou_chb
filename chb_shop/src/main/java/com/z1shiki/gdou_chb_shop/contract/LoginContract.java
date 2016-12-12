package com.z1shiki.gdou_chb_shop.contract;


import com.z1shiki.gdou_chb_shop.model.bean.User;
import com.z1shiki.gdou_chb_shop.util.MVP.BasePresenter;
import com.z1shiki.gdou_chb_shop.util.MVP.BaseView;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void loginprogress(boolean show);
        void populateAutoComplete();
        void showSnackbar();
    }

    interface Presenter extends BasePresenter {
        void login(User user);
    }
}
