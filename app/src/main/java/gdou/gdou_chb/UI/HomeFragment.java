package gdou.gdou_chb.ui;

import android.app.Fragment;
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

import com.roughike.bottombar.BottomBar;

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
    private static Fragment mFrament;



    @BindView(R.id.rvshop)
    RecyclerView rvShop;

    private ArrayList<Shop> mDataList;

    private HomeContract.ShopPresenter mPresenter;
    private BaseActivity mActivity;

    //private String[] name = { "商店1", "商店2", "商店3", "商店4", "商店5", "商店6", "商店7", "商店8" };
    //private String[] pics = { "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8" };

    public HomeFragment() { //Requires empty public constructor
        mFrament=this;
    }

    public static HomeFragment newInstanceState() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity= (BaseActivity) this.getActivity();
        mPresenter.doSerach();
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
//        setHasOptionsMenu(true);
        initData();
        //setup
        ButterKnife.bind(this, root);

        Toolbar mToolbar =
                (Toolbar) mActivity.findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mActivity.setSupportActionBar(mToolbar);

        BottomBar btb = (BottomBar) getActivity().findViewById(R.id.bottomBar);

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
        //添加
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

