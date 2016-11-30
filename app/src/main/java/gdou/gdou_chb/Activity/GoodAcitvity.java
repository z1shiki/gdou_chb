package gdou.gdou_chb.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.UI.GoodFragment;
import gdou.gdou_chb.presenter.GoodPresenter;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class GoodAcitvity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        ButterKnife.bind(this);

     GoodFragment mGoodFragment =
                (GoodFragment) getFragmentManager().findFragmentById(R.id.contentFrame);
        if(mGoodFragment == null){
            mGoodFragment = mGoodFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),mGoodFragment,R.id.contentFrame);
        }
        new GoodPresenter(
                //m,
                mGoodFragment);
    }
}
