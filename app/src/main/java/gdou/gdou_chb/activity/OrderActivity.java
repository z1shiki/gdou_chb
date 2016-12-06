package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.presenter.OrderPresenter;
import gdou.gdou_chb.ui.OrderFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.bottomBar;
import static gdou.gdou_chb.R.id.contentFrame;

/**
 * Created by Z1shiki on 2016/12/6.
 */

public class OrderActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(bottomBar)
    BottomBar mBottomBar;


    private OrderFragment mOrderFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);
        mToolbar.setTitle(null);
        mOrderFragment=
                (OrderFragment) getFragmentManager().findFragmentById(contentFrame);
        if (mOrderFragment == null) {
            mOrderFragment = OrderFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mOrderFragment, contentFrame);
        }
        new OrderPresenter(mOrderFragment);


        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        Log.i("sai", "Home ");
                        break;
                    case R.id.tab_order:
                        Log.i("sai", "order ");
                        break;
                    case R.id.tab_usercenter:
                        break;
                }
            }
        });
    }
}
