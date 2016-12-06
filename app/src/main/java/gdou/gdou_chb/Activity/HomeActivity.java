package gdou.gdou_chb.activity;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.List;

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
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(bottomBar)
    BottomBar mBottomBar;

    private List<Fragment> mFragmentList;

    private HomeFragment mHomeFragment;
    private OrderFragment mOrderFragment;
    private UserCenterFragment mCenterFragment;
    private Context HomeContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        HomeContext = this;
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);
        mToolbar.setTitle(null);
        mHomeFragment =
                (HomeFragment) getFragmentManager().findFragmentById(contentFrame);
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mHomeFragment, contentFrame);
        }
        mOrderFragment = OrderFragment.newInstanceState();
        mCenterFragment = UserCenterFragment.newInstanceState();

        new HomePresenter(this, mHomeFragment);


        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        Log.i("sai", "Home ");
                        break;
//                        if (mOrderFragment != null && mOrderFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(), mOrderFragment);
//                        }
//                        if (mCenterFragment != null && mCenterFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(), mCenterFragment);
//                        }
////                        mHomeFragment =
////                                (HomeFragment) getFragmentManager().findFragmentById(contentFrame);
//                        if (mHomeFragment == null) {
//                            mHomeFragment = HomeFragment.newInstanceState();
//                        }
//                        ActivityUtils.ShowFragment(getFragmentManager(),
//                                mHomeFragment,R.id.contentFrame);
//                        new HomePresenter(HomeContext, mHomeFragment);
//                        break;

                    case R.id.tab_order:
                        Log.i("sai", "order ");
                        break;
//                        if (mHomeFragment != null && mHomeFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(), mHomeFragment);
//                        }
//                        if (mCenterFragment != null && mCenterFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(), mCenterFragment);
//
//                        }
//                        Log.i("fm", "Hide");
////                        mOrderFragment =
////                                (OrderFragment) getFragmentManager().findFragmentById(contentFrame);
//                        if (mOrderFragment == null) {
//                            mOrderFragment = mOrderFragment.newInstanceState();
//                        }
//
//                            ActivityUtils.ShowFragment(getFragmentManager(),
//                                    mOrderFragment,R.id.contentFrame);
//                        Log.i("fm", "add");
//                        new OrderPresenter(mOrderFragment);

                    case R.id.tab_usercenter:
//                        if (mHomeFragment != null && mHomeFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(),mHomeFragment);
//                        }
//                        if (mOrderFragment != null && mOrderFragment.isAdded()) {
//                            ActivityUtils.HideFragment(getFragmentManager(),mOrderFragment);
//                        }
////                        mCenterFragment =
////                                (UserCenterFragment) getFragmentManager().findFragmentById(contentFrame);
//                        if (mCenterFragment == null) {
//                            mCenterFragment = mCenterFragment.newInstanceState();
//                        }
//                        ActivityUtils.ShowFragment(getFragmentManager(),
//                                mCenterFragment,R.id.contentFrame);
//                        new UsercenterPresenter(mCenterFragment);
                }
            }
        });
    }
}

