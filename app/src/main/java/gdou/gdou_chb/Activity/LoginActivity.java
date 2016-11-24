package gdou.gdou_chb.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.data.user.User;
import gdou.gdou_chb.features.user.login.LoginFragment;
import gdou.gdou_chb.presenter.LoginPresenter;
import gdou.gdou_chb.util.ActivityUtils;
import gdou.gdou_chb.util.BaseActivity;
import gdou.gdou_chb.util.Injection;

/**
 * Created by Z1shiki on 2016/11/21.
 */

public class LoginActivity extends BaseActivity {
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        ButterKnife.bind(this);
        User mUser =null;

        LoginFragment mLoginFragment =
                (LoginFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mLoginFragment == null) {
            mLoginFragment = LoginFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(), mLoginFragment, R.id.contentFrame);
        }

//        Create the presenter TODO：此处需要实现创建Model实例
        mLoginPresenter = new LoginPresenter(
                mUser,
                Injection.provideUsersRepository(this),
                mLoginFragment);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
