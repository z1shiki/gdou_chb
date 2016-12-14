package gdou.gdou_chb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.adapter.ShopAdapter;
import gdou.gdou_chb.car.ShoppingCartActivity;
import gdou.gdou_chb.contract.HomeContract;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.util.GsonUtils;
import gdou.gdou_chb.util.Java.BaseActivity;
import gdou.gdou_chb.util.MVP.BaseFragment;
import gdou.gdou_chb.util.SnackbarUtil;


/**
 * Created by Z1shiki on 2016/11/16.
 */

public class HomeFragment extends BaseFragment implements HomeContract.ShopView {

    @BindView(R.id.rvshop)
    RecyclerView rvShop;

    private ArrayList<Shop> mDataList;
    private HomeContract.ShopPresenter mPresenter;
    private BaseActivity mActivity;
    private ShopAdapter adapter;

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

        //初始化列表
        //shop = Shop.createShopList(20);
        //创建适配器
        adapter = new ShopAdapter(mActivity, mDataList);
        //绑定适配器
        rvShop.setAdapter(adapter);
        //设置布局管理器
        rvShop.setLayoutManager(new LinearLayoutManager(mActivity));
        //固定大小
        rvShop.setHasFixedSize(true);
        //设置增加或删除条目的动画
        rvShop.setItemAnimator(new DefaultItemAnimator());

        setViewLintener();

        return root;
    }

    private void setViewLintener() {
       adapter.setOnItemClickListener(new ShopAdapter.MyItemClickListener() {
           @Override
           public void onItemClick(View view, int postion) {
               Shop shop = mDataList.get(postion);
               Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
               if (null != shop) {
                   intent.putExtra("shopId", shop.getId());
                   intent.putExtra("businessId", shop.getBusinessId());
                   startActivity(intent);
               }
           }
       });
    }


    private void initData() {
        mPresenter.getShopList();
        mDataList = new ArrayList<>();
        }




    @Override
    public void setLocation(String string) {
        Toolbar mtoolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        if(string == null)
            mtoolbar.setTitle("123");
        mtoolbar.setTitle(string);
    }

    @Override
    public void changeShoplist(List<Shop> shopList) {
        Log.d("shopS--->", GsonUtils.getJsonStr(shopList));
        Log.d("size", shopList.size() + "");
        for (Shop shop : shopList) {
            if (null != shop)
                mDataList.add(shop);
        }
        Log.d("size", mDataList.size() + "");
        Log.d("dataList", GsonUtils.getJsonStr(mDataList));
        adapter.notifyDataSetChanged();
    }

    @Override

    public void ShowShop(String string) {
//        Glide
//                .with(getActivity())
//                .load(string)
//                .into();

    }

    @Override
    public void showSnackbar(int i) {
        switch (i){
            case 0:
                SnackbarUtil.LongSnackbar(getActivity().findViewById(R.id.contentFrame)
                        , "定位失败",4).show();
                break;
            case 1:
                SnackbarUtil.LongSnackbar(getActivity().findViewById(R.id.contentFrame)
                        , "读取商店失败",4).show();
                break;
        }

    }


    //对NavigationIcon添加点击
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            Intent intent = new Intent(getActivity(), MapActivity.class);
//            startActivity(intent);
            mPresenter.initAmap();
            mPresenter.getGPS();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

