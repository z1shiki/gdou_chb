package com.z1shiki.gdou_chb_shop.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.z1shiki.gdou_chb_shop.R;
import com.z1shiki.gdou_chb_shop.presenter.HomePresenter;
import com.z1shiki.gdou_chb_shop.ui.HomeFragment;
import com.z1shiki.gdou_chb_shop.ui.OrderFragment;
import com.z1shiki.gdou_chb_shop.ui.UserCenterFragment;
import com.z1shiki.gdou_chb_shop.util.Java.ActivityUtils;
import com.z1shiki.gdou_chb_shop.util.Java.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.bottomBar)
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
        mHomeFragment =
                (HomeFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mHomeFragment, R.id.contentFrame);
        }
        new HomePresenter(this, mHomeFragment);


        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        if(mHomeFragment == null)
                            mHomeFragment= HomeFragment.newInstanceState();
//                        ActivityUtils.replaceFragment(getFragmentManager(),mHomeFragment,R.id.contentFrame);
                        new HomePresenter(getParent(),mHomeFragment);
                        Log.i("sai", "Home ");
                        break;
                    case R.id.tab_order:
                        if(mOrderFragment == null)
                            mOrderFragment = OrderFragment.newInstanceState();
//                        ActivityUtils.replaceFragment(getFragmentManager(),mOrderFragment,R.id.contentFrame);
//                        new OrderPresenter(mOrderFragment,new OrderModelImpl());
                        Log.i("sai", "order ");

                        break;
                    case R.id.tab_usercenter:
                        Log.i("sai", "order ");
                        if(mCenterFragment == null)
                            mCenterFragment = UserCenterFragment.newInstanceState();
                        ActivityUtils.replaceFragment(getFragmentManager(),mCenterFragment,R.id.contentFrame);
//                        new UsercenterPresenter(mCenterFragment);
                        break;
                }
            }
        });
    }
}


