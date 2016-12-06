package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.ui.SafeCenterFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.contentFrame;
import static gdou.gdou_chb.ui.SafeCenterFragment.newInstanceState;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class SafeCenterActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safecenter_act);
        ButterKnife.bind(this);
//        mToolbar.setTitle(null);
        SafeCenterFragment mSafeCenterFragment =
                (SafeCenterFragment) getFragmentManager().findFragmentById (contentFrame);
        if (mSafeCenterFragment == null) {
            mSafeCenterFragment = newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mSafeCenterFragment, contentFrame);
        }

    }
}
