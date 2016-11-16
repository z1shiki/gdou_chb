package gdou.gdou_chb.UI;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import gdou.gdou_chb.MVP.other.BaseActivity;
import gdou.gdou_chb.R;

public class MainActivity extends BaseActivity{
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
}
