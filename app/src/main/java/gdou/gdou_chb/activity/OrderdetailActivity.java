package gdou.gdou_chb.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.kymjs.rxvolley.rx.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.OrderModel;
import gdou.gdou_chb.model.bean.OrderDetail;
import gdou.gdou_chb.model.bean.Orders;
import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.impl.OrderModelImpl;
import gdou.gdou_chb.util.GsonUtils;
import gdou.gdou_chb.util.Java.BaseActivity;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by WT on 2016/12/9.
 */

public class OrderdetailActivity extends BaseActivity {
    @BindView(R.id.order_num)
    TextView orderNum;
    @BindView(R.id.shop_name)
    TextView shopName;
    @BindView(R.id.rvorder_details)
    RecyclerView rvorderDetails;
    @BindView(R.id.total_price)
    TextView totalPrice;

    private CompositeSubscription mSubscription;
    private Orders orders;
    private OrderModel ordermodel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details_act);
        ButterKnife.bind(this);
        mSubscription = new CompositeSubscription();

        initData();
    }

    private void initData() {
        if (null == getIntent().getStringExtra("order"))
            return;
        orders = GsonUtils.parseJsonWithGson(getIntent().getStringExtra("order"), Orders.class);
        initViewData();
        ordermodel = new OrderModelImpl();
        ordermodel.getOrderDetail(orders.getId())
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
                                                                   Log.d("OrderdetailActivity", "succ");
                                                               }

                                                               @Override
                                                               public void onError(Throwable e) {
                                                                   Log.d("OrderdetailActivity","error");
                                                                   Log.e("OrderdetailActivity", "onError: 错误信息",e );
                                                               }

                                                               @Override
                                                               public void onNext(String string) {
                                                                   Log.d("OrderdetailActivity","result:" + string);
                                                                   ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                                                   //解析成对应的对象
                                                                   List<OrderDetail> orderDetaList = GsonUtils
                                                                           .getBeanFromResultBeanListMiss(resultBean,"orderDetailList",
                                                                                   OrderDetail[].class);

                                                               }
                                                           }
                                                );

    }

    private void initViewData() {
        orderNum.setText(orders.getName());
        totalPrice.setText(orders.getTotalPrice() + "");

//        adapter = new OrderDetailAdapter(this)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscription.clear();
    }
}
