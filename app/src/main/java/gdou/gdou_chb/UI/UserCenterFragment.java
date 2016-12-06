package gdou.gdou_chb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gdou.gdou_chb.R;
import gdou.gdou_chb.activity.AddressActivity;
import gdou.gdou_chb.activity.SafeCenterActivity;
import gdou.gdou_chb.activity.SettingActivity;
import gdou.gdou_chb.contract.HomeContract;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class UserCenterFragment extends BaseFragment implements HomeContract.UserCenterView {

    @BindView(R.id.safe_center)
    TextView safeCenter;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.setting)
    TextView setting;
    private HomeContract.UserCenterPresenter mPresenter;

    public UserCenterFragment() { //Requires empty public constructor
    }

    public static UserCenterFragment newInstanceState() {
        return new UserCenterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull HomeContract.UserCenterPresenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.usercenter_frag, container, false);


        //setup
        ButterKnife.bind(this, root);


        return root;
    }

    @OnClick({R.id.safe_center, R.id.address, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.safe_center:
                jump2Activity(SafeCenterActivity.class);
                break;
            case R.id.address:
                jump2Activity(AddressActivity.class);
                break;
            case R.id.setting:
                jump2Activity(SettingActivity.class);
                break;
        }
    }
}