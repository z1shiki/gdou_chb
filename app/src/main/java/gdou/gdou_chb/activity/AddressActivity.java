package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.ui.AddressFragment;
import gdou.gdou_chb.util.Java.ActivityUtils;
import gdou.gdou_chb.util.Java.BaseActivity;

import static gdou.gdou_chb.R.id.contentFrame;


/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class AddressActivity extends BaseActivity{
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        jump2Activity(HomeActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_act);
        ButterKnife.bind(this);
//        mToolbar.setTitle(null);
        AddressFragment mAddressFragment =
                (AddressFragment) getFragmentManager().findFragmentById(contentFrame);
        if(mAddressFragment == null){
            mAddressFragment = AddressFragment.newInstanceState();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),mAddressFragment, contentFrame);
        }

    }
}

