package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.kymjs.rxvolley.rx.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.AddressModel;
import gdou.gdou_chb.model.bean.Address;
import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.impl.AddressModelImpl;
import gdou.gdou_chb.model.impl.BaseModelImpl;
import gdou.gdou_chb.util.GsonUtils;
import gdou.gdou_chb.util.Java.BaseActivity;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by WT on 2016/12/9.
 */

public class AddAddressActivity extends BaseActivity {

    @BindView(R.id.submit)
    Button submitBtn;
    @BindView(R.id.address_addressname)
    EditText input_addressName;
    @BindView(R.id.address_phone)
    EditText input_phone;
    @BindView(R.id.address_username)
    EditText input_userName;

    private AddressModel addressModel;
    CompositeSubscription mSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        ButterKnife.bind(this);
        mSubscription = new CompositeSubscription();
        initData();

    }

    private void initData() {
        addressModel = new AddressModelImpl();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscription.clear();
    }

    @OnClick(R.id.submit)
    public void onClick() {
        Subscription subscription = addressModel.addAddress(setData())
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
                                                                   Log.d("AddAddressActivity", "succ");
                                                               }

                                                               @Override
                                                               public void onError(Throwable e) {
                                                                   Log.d("AddAddressActivity","error");
                                                                   Log.e("AddAddressActivity", "onError: 错误信息",e );
                                                               }

                                                               @Override
                                                               public void onNext(String string) {
                                                                   Log.d("AddAddressActivity","result:" + string);
                                                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                                                   //解析成对应的对象
                                                                   Log.d("AddressAdd", "onNext: " + resultBean.getResultInfo());
                                                               }
                                                           }
                                                );
        mSubscription.add(subscription);
    }

    private Address setData() {
        Address address = new Address();
        address.setUserId(BaseModelImpl.user.getId());
        address.setAddressName(input_addressName.getText().toString());
        address.setPhone(input_phone.getText().toString());
        address.setLatitude(123.3);
        address.setLongitude(123.3);
        address.setName(input_userName.getText().toString());
        return address;
    }
}
