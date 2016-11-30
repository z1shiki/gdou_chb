package gdou.gdou_chb.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.UI.LoginFragment;
import gdou.gdou_chb.data.bean.User;
import gdou.gdou_chb.presenter.LoginPresenter;
import gdou.gdou_chb.util.Injection;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;


/**
 * Created by Z1shiki on 2016/11/21.
 */

public class LoginActivity extends BaseActivity {

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
        new LoginPresenter(
                mUser,
                Injection.provideUsersRepository(this),
                mLoginFragment);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
