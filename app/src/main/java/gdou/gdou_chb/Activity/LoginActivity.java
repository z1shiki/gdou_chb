package gdou.gdou_chb.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.UI.LoginFragment;
import gdou.gdou_chb.model.impl.UserModelImpl;
import gdou.gdou_chb.presenter.LoginPresenter;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;


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
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), mLoginFragment, R.id.contentFrame);
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
