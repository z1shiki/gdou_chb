package gdou.gdou_chb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.adapter.ShopAdapter;
import gdou.gdou_chb.contract.HomeContract;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.util.Java.BaseActivity;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class HomeFragment extends BaseFragment implements HomeContract.ShopView {

    @BindView(R.id.rvshop)
    RecyclerView rvShop;

    private ArrayList<Shop> mDataList;
    private HomeContract.ShopPresenter mPresenter;
    private BaseActivity mActivity;

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
        //mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mActivity= (BaseActivity) this.getActivity();
        //mPresenter.unsubscribe();

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

        //初始化列表
        //shop = Shop.createShopList(20);
        //创建适配器
        ShopAdapter adapter = new ShopAdapter(mActivity, mDataList);
        //绑定适配器
        rvShop.setAdapter(adapter);
        //设置布局管理器
        rvShop.setLayoutManager(new LinearLayoutManager(mActivity));
        //固定大小
        rvShop.setHasFixedSize(true);
        //设置增加或删除条目的动画
        rvShop.setItemAnimator(new DefaultItemAnimator());

        return root;
    }



    private void initData() {
        mDataList = new ArrayList<>();
        //添加假数据
        mDataList.add(new Shop(getString(R.string.news_one_title)));
        mDataList.add(new Shop(getString(R.string.news_two_title)));
        mDataList.add(new Shop(getString(R.string.news_three_title)));
        mDataList.add(new Shop(getString(R.string.news_four_title)));

        }




    @Override
    public void setLocation() {

    }

    @Override
    public void changeShoplist() {

    }

    @Override
    public void choiceShop() {


    }


}

