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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.adapter.OrderAdapter;
import gdou.gdou_chb.contract.HomeContract;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.util.Java.BaseActivity;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class OrderFragment extends BaseFragment implements HomeContract.OrderView {

//    @BindView(R.id.toolbar)
//    Toolbar mToolBar;
//    @BindView(R.id.toolbar_text)
//    TextView mToolBarText;
    @BindView(R.id.rvorder)
RecyclerView rvOrder;

//    private ArrayList<Orders> mDataList;
    private HomeContract.OrderPresenter mPresenter;
    private BaseActivity mActivity;

    public OrderFragment() { //Requires empty public constructor
    }

    public static OrderFragment newInstanceState() {
        return new OrderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) this.getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        mActivity = (BaseActivity) this.getActivity();
        //mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mActivity = (BaseActivity) this.getActivity();
        //mPresenter.unsubscribe();

    }

    @Override
    public void setPresenter(@NonNull HomeContract.OrderPresenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.order_frag, container, false);
        setHasOptionsMenu(true);
//        initData();
        //setup
        ButterKnife.bind(this, root);

        Toolbar mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        //mToolBarText.setText("订单");
        ((BaseActivity)getActivity()).setSupportActionBar(mToolbar);

        //RecyclerView rvOrder = (RecyclerView) mActivity.findViewById(R.id.rvorder);
        //创建适配器
        OrderAdapter adapter = new OrderAdapter(mActivity, mDataList());
        //绑定适配器
        rvOrder.setAdapter(adapter);
        //设置布局管理器
        rvOrder.setLayoutManager(new LinearLayoutManager(mActivity));
        //固定大小
        rvOrder.setHasFixedSize(true);
        //设置增加或删除条目的动画
        rvOrder.setItemAnimator(new DefaultItemAnimator());
        //adapter.setOnItemClickListener(this);
        //adapter.setOnRecyclerViewListener(this);
        //adapter.notifyDataSetChanged();

        return root;
    }

    public List<Orders> mDataList(){
        List<Orders> data = new ArrayList<>();
        for (int i =0; i<30; i++){
            Orders orders = new Orders();
//            orders.setShopName("商店名字");
//            orders.setOrderNum(123);
            data.add(orders);
        }
        return data;
    }

//    private void initData() {
//        //添加
//        mDataList.add(new Orders(getString(R.string.news_one_title),getString(R.string.a)));
//        mDataList.add(new Orders(getString(R.string.news_two_title),getString(R.string.b)));
//        mDataList.add(new Orders(getString(R.string.news_three_title),getString(R.string.c)));
//        mDataList.add(new Orders(getString(R.string.news_four_title),getString(R.string.d)));
//    }

}