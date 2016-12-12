package com.z1shiki.gdou_chb_shop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.z1shiki.gdou_chb_shop.R;
import com.z1shiki.gdou_chb_shop.model.impl.UserModelImpl;
import com.z1shiki.gdou_chb_shop.presenter.LoginPresenter;
import com.z1shiki.gdou_chb_shop.ui.LoginFragment;
import com.z1shiki.gdou_chb_shop.util.Java.ActivityUtils;
import com.z1shiki.gdou_chb_shop.util.Java.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Z1shiki on 2016/11/21.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_text)
    TextView mToolbarText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        ButterKnife.bind(this);
        mToolbarText.setText("登录");

        LoginFragment mLoginFragment =
                (LoginFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mLoginFragment == null) {
            mLoginFragment = LoginFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mLoginFragment, R.id.contentFrame);
        }

//        Create the presenter TODO：此处需要实现创建Model实例
        new LoginPresenter(
                new UserModelImpl(),//usermodel
                mLoginFragment);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
