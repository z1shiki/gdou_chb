package gdou.gdou_chb.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.presenter.HomePresenter;
import gdou.gdou_chb.ui.HomeFragment;
import gdou.gdou_chb.ui.OrderFragment;
import gdou.gdou_chb.ui.UserCenterFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.bottomBar;
import static gdou.gdou_chb.R.id.contentFrame;

public class HomeActivity extends BaseActivity {
//    @BindView(R.id.toolbar)
//    Toolbar mToolbar;
    @BindView(bottomBar)
    BottomBar mBottomBar;

    private HomePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);
//        mToolbar.setTitle(null);
        HomeFragment mHomeFragment =
                (HomeFragment) getFragmentManager().findFragmentById(contentFrame);
        if(mHomeFragment == null){
            mHomeFragment = HomeFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),mHomeFragment, contentFrame);
        }
        mPresenter = new HomePresenter(this,mHomeFragment);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentFrame,new HomeFragment()).commit();
                        break;
                    case R.id.tab_order:
                        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentFrame,new OrderFragment()).commit();
                        break;
                    case R.id.tab_usercenter:
                        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contentFrame,new UserCenterFragment()).commit();
                        break;
                }
            }
        });

    }

}
