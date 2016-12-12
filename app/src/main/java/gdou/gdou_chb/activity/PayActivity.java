package gdou.gdou_chb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kymjs.rxvolley.rx.Result;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.impl.AddressModelImpl;
import gdou.gdou_chb.model.impl.BaseModelImpl;
import gdou.gdou_chb.util.GsonUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class PayActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.pay_onlie)
    Button payBtn;
    @BindView(R.id.pay_no_onlie)
    Button noPayBtn;

    @BindView(R.id.pay_address_list)
    RecyclerView addressListView;

    private List<Address> mAddressList;
    private CommonAdapter<Address> mAdapter;

    private Long selectAddressId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);

        initData();

        initView();

    }

    private void initView() {

        mAdapter = new CommonAdapter<Address>(this, R.layout.address_item, mAddressList) {
            @Override
            protected void convert(ViewHolder holder, Address address, int position) {
                holder.setText(R.id.address_phone, address.getPhone());
                holder.setText(R.id.address_username, address.getName());
                holder.setText(R.id.address_name, address.getAddressName());
            }
        };

        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                selectAddressId = mAddressList.get(position).getId();
                Toast.makeText(getApplication() , "你选择了" + position , Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        payBtn.setOnClickListener(this);
        noPayBtn.setOnClickListener(this);

    }

    private void initData() {

        mAddressList = new ArrayList<>();

        new AddressModelImpl().all(BaseModelImpl.user.getId()).map(new Func1<Result, String>() {

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
                                                   Log.d("PayActivity", "succ");
                                               }

                                               @Override
                                               public void onError(Throwable e) {
                                                   Log.d("PayActivity==>","error");
                                                   Log.e("PayActivity", "登录错误信息", e);
                                               }

                                               @Override
                                               public void onNext(String string) {
                                                   Log.d("Login", "onNext: " + string);
                                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                                   //进行数据处理

                                                   List<Address> addresses = GsonUtils
                                                           .getBeanFromResultBeanListMiss(resultBean,
                                                                   "addressList", Address[].class);
                                                   mAddressList.addAll(addresses);
                                                   mAdapter.notifyDataSetChanged();
                                               }
                                           }
                                );
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pay_no_onlie) {
            //货到付款
        } else {
            //在线支付
        }
    }
}
