package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.ui.AboutFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.contentFrame;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_act);
        ButterKnife.bind(this);
//        mToolbar.setTitle(null);
        AboutFragment mAboutFragment =
                (AboutFragment) getFragmentManager().findFragmentById (contentFrame);
        if (mAboutFragment == null) {
            mAboutFragment = AboutFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mAboutFragment, contentFrame);
        }

    }
}