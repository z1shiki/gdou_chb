package gdou.gdou_chb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import gdou.gdou_chb.R;
import gdou.gdou_chb.model.bean.Orders;

/**
 * Created by Administrator on 2016/12/2/0002.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
        //存储context变量
        private Context mContext;
        //创建一个存储商店的成员变量
        private List<Orders> mOrderData;//= Datas.getData(100)
        private LayoutInflater mLayoutInflater;


    public void setMyOnClickLinstener(MyOnClickLinstener myOnClickLinstener) {
        this.myOnClickLinstener = myOnClickLinstener;
    }

    private MyOnClickLinstener myOnClickLinstener;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView TotalPrice;
            public TextView userName;
            public TextView OrderStatus;
            public TextView GoodsName;
            public TextView OrderAddress;

            private Button doneBtn;
            private Button backBtn;

            //构造方法接受每一项的布局作为参数，存储成员变量以便于访问
            public ViewHolder(View itemView){
                super(itemView);
                TotalPrice = (TextView) itemView.findViewById(R.id.total_price);
                userName = (TextView) itemView.findViewById(R.id.user_name);
                OrderStatus = (TextView) itemView.findViewById(R.id.order_status);
                GoodsName = (TextView) itemView.findViewById(R.id.good_name);
                OrderAddress = (TextView) itemView.findViewById(R.id.order_num);

                doneBtn = (Button) itemView.findViewById(R.id.confirm_receipt_btn);
                backBtn = (Button) itemView.findViewById(R.id.charge_back_btn);

                doneBtn.setOnClickListener(this);
                backBtn.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                view.setEnabled(false);
                myOnClickLinstener.btnClick(view.getId(), mOrderData.get(getPosition()).getId() );
            }

        }

        //为了方便的访问Context变量
        public OrderAdapter(Context context, List<Orders> datas){
            this.mContext = context;
            this.mOrderData = datas;
            this.notifyDataSetChanged();
            mLayoutInflater = LayoutInflater.from(context);

        }

        public Context getContext(){
            return mContext;
        }

        //加载item布局并且创造holder对象
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            //加载自定义布局
            View item = mLayoutInflater.inflate(R.layout.item_order, parent, false);
            //返回一个holder实例
            return new ViewHolder(item);
        }
        //通过holder将数据填充进项
        @Override
        public void onBindViewHolder(ViewHolder holder, int position){
            //得到数据的对象
            Orders orders = mOrderData.get(position);
            //设置itemView的内容
              holder.TotalPrice.setText(orders.getTotalPrice() + "");
              holder.OrderStatus.setText(selectOrdersStatus(orders.getStatus()));
              holder.userName.setText(orders.getName());
              holder.OrderAddress.setText(orders.getAddress());
//              holder.GoodsName.setText(orders.getGoodsName());

        }
        //返回项的数量
        @Override
        public int getItemCount(){
            return mOrderData == null ? 0 : mOrderData.size();
        }

    /**
     * 设置订单状态
     * @param status
     * @return
     */
    private String selectOrdersStatus (Integer status){
        String result = "";
        switch (status) {
            case 1:
                result = "已下单";
                break;
            case 2:
                result = "已支付";
                break;
            case 3:
                result = "已接单";
                break;
            case 4:
                result = "正在配送";
                break;
            case 5:
                result = "待评价";
                break;
            case 6:
                result = "已完成";
                break;
            case 7:
                result = "取消订单";
                break;
            default:
                result ="订单XXX";
                break;
        }
        return result;
    }

    public interface MyOnClickLinstener{
        void btnClick(int viewId, Long orderId);
    }

}
