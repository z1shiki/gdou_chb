package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.ui.HomeFragment;
import gdou.gdou_chb.presenter.HomePresenter;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

public class HomeActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);

        HomeFragment mHomeFragment =
                (HomeFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if(mHomeFragment == null){
            mHomeFragment = HomeFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),mHomeFragment,R.id.contentFrame);
        }
        new HomePresenter(this,mHomeFragment);
    }
}
