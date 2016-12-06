package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.ui.ReportFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.contentFrame;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class ReportActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_act);
        ButterKnife.bind(this);
//        mToolbar.setTitle(null);
        ReportFragment mReportFragment =
                (ReportFragment) getFragmentManager().findFragmentById (contentFrame);
        if (mReportFragment == null) {
            mReportFragment = ReportFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(), mReportFragment, contentFrame);
        }

    }
}
