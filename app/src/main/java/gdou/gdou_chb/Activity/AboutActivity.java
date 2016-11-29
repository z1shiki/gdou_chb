package gdou.gdou_chb.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.util.Java.BaseActivity;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class AboutActivity extends BaseActivity {
    private gdou.gdou_chb.presenter.AboutPresenter mAboutPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_act);
        ButterKnife.bind(this);
    }
}
