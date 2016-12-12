package com.z1shiki.gdou_chb_shop.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.z1shiki.gdou_chb_shop.R;
import com.z1shiki.gdou_chb_shop.contract.HomeContract;
import com.z1shiki.gdou_chb_shop.model.bean.Shop;
import com.z1shiki.gdou_chb_shop.util.Java.BaseActivity;
import com.z1shiki.gdou_chb_shop.util.MVP.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Z1shiki on 2016/11/16.
 */

public class HomeFragment extends BaseFragment implements HomeContract.ShopView {

    @BindView(R.id.rvshop)
    RecyclerView rvShop;

    private ArrayList<Shop> mDataList;
    private HomeContract.ShopPresenter mPresenter;
    private BaseActivity mActivity;
//    private ShopAdapter adapter;

    public HomeFragment() { //Requires empty public constructor
    }

    public static HomeFragment newInstanceState() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity= (BaseActivity) this.getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity= (BaseActivity) this.getActivity();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mActivity= (BaseActivity) this.getActivity();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull HomeContract.ShopPresenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_frag, container, false);
        setHasOptionsMenu(true);

        initData();
        //setup
        ButterKnife.bind(this, root);

        Toolbar mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        ((BaseActivity)getActivity()).setSupportActionBar(mToolbar);
        mPresenter.getGPS();


        return root;
    }



    private void initData() {
        mPresenter.getShopList();
        mDataList = new ArrayList<>();
        }




    @Override
    public void setLocation(String string) {
        Toolbar mtoolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) getActivity().findViewById(R.id.toolbar_text);
        mTitle.setText(string);
        mtoolbar.setTitle((CharSequence) mTitle);
    }

    @Override
    public void changeShoplist(List<Shop> shopList) {
    }

    @Override
    public void choiceShop() {
        Log.d("你的点击了"," 你点击了");

    }

    @Override
    public void showSnackbar() {

    }


}

