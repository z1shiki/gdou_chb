package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.impl.UserModelImpl;
import gdou.gdou_chb.presenter.LoginPresenter;
import gdou.gdou_chb.ui.LoginFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class RateActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_act);
        ButterKnife.bind(this);

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
}
