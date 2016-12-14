package gdou.gdou_chb.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.impl.OrderModelImpl;
import gdou.gdou_chb.model.impl.ShopModelImpl;
import gdou.gdou_chb.presenter.HomePresenter;
import gdou.gdou_chb.presenter.OrderPresenter;
import gdou.gdou_chb.presenter.UsercenterPresenter;
import gdou.gdou_chb.ui.HomeFragment;
import gdou.gdou_chb.ui.OrderFragment;
import gdou.gdou_chb.ui.UserCenterFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.bottomBar;
import static gdou.gdou_chb.R.id.contentFrame;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(bottomBar)
    BottomBar mBottomBar;


    private HomeFragment mHomeFragment;
    private OrderFragment mOrderFragment;
    private UserCenterFragment mCenterFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);
        mToolbar.setTitle(null);
        mToolbar.setNavigationIcon(R.drawable.ic_location);

        mHomeFragment =
                (HomeFragment) getFragmentManager().findFragmentById(contentFrame);
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mHomeFragment, contentFrame);
        }
        new HomePresenter(mHomeFragment,new ShopModelImpl());


        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        if(mHomeFragment == null)
                            mHomeFragment= HomeFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mHomeFragment,R.id.contentFrame);
                        new HomePresenter(mHomeFragment,new ShopModelImpl());
                        break;
                    case R.id.tab_order:
                        if(mOrderFragment == null)
                            mOrderFragment = OrderFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mOrderFragment,R.id.contentFrame);
                        new OrderPresenter(mOrderFragment,new OrderModelImpl());

                        break;
                    case R.id.tab_usercenter:
                        if(mCenterFragment == null)
                            mCenterFragment = UserCenterFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mCenterFragment,R.id.contentFrame);
                        new UsercenterPresenter(mCenterFragment);
                        break;
                }
            }
        });

        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_home:
                        if(mHomeFragment == null)
                            mHomeFragment= HomeFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mHomeFragment,R.id.contentFrame);
                        new HomePresenter(mHomeFragment,new ShopModelImpl());
                        break;
                    case R.id.tab_order:
                        if(mOrderFragment == null)
                            mOrderFragment = OrderFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mOrderFragment,R.id.contentFrame);
                        new OrderPresenter(mOrderFragment,new OrderModelImpl());

                        break;
                    case R.id.tab_usercenter:
                        if(mCenterFragment == null)
                            mCenterFragment = UserCenterFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mCenterFragment,R.id.contentFrame);
                        new UsercenterPresenter(mCenterFragment);
                        break;
                }
            }
        });

    }
}


