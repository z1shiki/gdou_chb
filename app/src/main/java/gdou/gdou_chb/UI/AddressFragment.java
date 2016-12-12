package gdou.gdou_chb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kymjs.rxvolley.rx.Result;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.activity.AddAddressActivity;
import gdou.gdou_chb.activity.AddressActivity;
import gdou.gdou_chb.contract.AddressContract;
import gdou.gdou_chb.model.AddressModel;
import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.impl.AddressModelImpl;
import gdou.gdou_chb.model.impl.BaseModelImpl;
import gdou.gdou_chb.util.GsonUtils;
import gdou.gdou_chb.util.MVP.BaseFragment;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class AddressFragment extends BaseFragment implements AddressContract.View {

    private AddressModel addressModel;

    @BindView(R.id.address_view)
    public RecyclerView addressListView;
    @BindView(R.id.address_add_btn)
    public FloatingActionButton addBtn;

    private CommonAdapter<Address> addressAdapter;
    private ArrayList<Address> mAddressList;

    public AddressFragment() { //Requires empty public constructor
    }

    public static AddressFragment newInstanceState() {
        return new AddressFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void setPresenter(@NonNull AddressContract.Presenter presenter) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.address_frag, container, false);
        //setup
        ButterKnife.bind(this, root);
        initView();
        addressModel = new AddressModelImpl();
        initData();
        return root;
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mAddressList = new ArrayList<Address>();
        addressAdapter = new CommonAdapter<Address>(getActivity(), R.layout.address_item, mAddressList) {
            @Override
            protected void convert(ViewHolder holder, Address address, int position) {
                holder.setText(R.id.address_phone, address.getPhone());
                holder.setText(R.id.address_name, address.getAddressName());
                holder.setText(R.id.address_username, address.getName());
            }
        };
        addressListView.setAdapter(addressAdapter);
        addressAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Address address = mAddressList.get(position);
                String addressJson = GsonUtils.getJsonStr(address);
                Intent intent = new Intent(getActivity(), AddressActivity.class);
                intent.putExtra("address",addressJson);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        addressListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddAddressActivity.class));
            }
        });
    }

    /**
     * 获取用户的所有地址
     */
    private void initData() {
        addressModel.all(BaseModelImpl.user.getId())
                .map(new Func1<Result, String>() {

                                    @Override
                                    public String call(Result result) {
                                        return new String(result.data);
                                    }
                                } )
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Subscriber<String>() {
                                               @Override
                                               public void onCompleted() {
                                                   Log.d("AddressFragment", "succ");
                                               }

                                               @Override
                                               public void onError(Throwable e) {
                                                   Log.d("AddressFragment==>","error");
                                                   Log.e("AddressFragment", "登录错误信息", e);

                                               }

                                               @Override
                                               public void onNext(String string) {
                                                   Log.d("Login", "onNext: " + string);
                                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                                   //进行数据处理
                                                   List<Address> addressList = GsonUtils.
                                                           getBeanFromResultBeanListMiss(resultBean,
                                                                   "addressList", Address[].class);
                                                   mAddressList.addAll(addressList);
                                                   Log.d("数据量", "onNext: " + addressList.size());
                                                   addressAdapter.notifyDataSetChanged();
                                               }
                                           }
                                );
    }
}