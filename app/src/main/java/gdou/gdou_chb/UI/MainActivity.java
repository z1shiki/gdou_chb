package gdou.gdou_chb.UI;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import gdou.gdou_chb.MVP.MainView;
import gdou.gdou_chb.MVP.main.MainPresenter;
import gdou.gdou_chb.MVP.other.BaseActivity;
import gdou.gdou_chb.R;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView{
    @BindView(R.id.user_bottombar)BottomBar bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

            }
        });
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void onTabSelect(int tabId) {

    }

    @Override
    public void onTabReSelect(int tabId) {

    }
}
