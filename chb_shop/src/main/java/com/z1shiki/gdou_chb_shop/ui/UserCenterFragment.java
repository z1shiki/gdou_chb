package com.z1shiki.gdou_chb_shop.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.z1shiki.gdou_chb_shop.R;
import com.z1shiki.gdou_chb_shop.contract.HomeContract;
import com.z1shiki.gdou_chb_shop.model.impl.BaseModelImpl;
import com.z1shiki.gdou_chb_shop.util.MVP.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Z1shiki on 2016/11/16.
 */

public class UserCenterFragment extends BaseFragment implements HomeContract.UserCenterView {


    TextView user_name;
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
//        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
//        mPresenter.unsubscribe();
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

        initView();

        return root;
    }

    private void initView() {

        user_name.setText(BaseModelImpl.user.getAccount());
    }

    @OnClick({R.id.safe_center, R.id.address, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.safe_center:
//                jump2Activity(SafeCenterActivity.class);
                break;
            case R.id.address:
//                jump2Activity(AddressActivity.class);
                break;
            case R.id.setting:
//                jump2Activity(SettingActivity.class);
                break;
        }
    }
}