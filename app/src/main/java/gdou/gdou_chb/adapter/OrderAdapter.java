package gdou.gdou_chb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        public static class ViewHolder extends RecyclerView.ViewHolder{
//            public TextView TotalPrice;
              public TextView ShopName;
//            public TextView OrderStatus;
//            public TextView GoodsName;
              public TextView OrderNum;

            //构造方法接受每一项的布局作为参数，存储成员变量以便于访问
            public ViewHolder(View itemView){
                super(itemView);
//                TotalPrice = (TextView) itemView.findViewById(R.id.total_price);
                  ShopName = (TextView) itemView.findViewById(R.id.shop_name);
//                OrderStatus = (TextView) itemView.findViewById(R.id.order_status);
//                GoodsName = (TextView) itemView.findViewById(R.id.good_name);
                  OrderNum = (TextView) itemView.findViewById(R.id.order_num);
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
//            holder.TotalPrice.setText(orders.getTotalPrice());
//            holder.OrderStatus.setText(orders.getStatus());
              holder.ShopName.setText((int) orders.getShopId());
              //holder.OrderNum.setText(orders.getOrderNum());
//            holder.GoodsName.setText(orders.getGoodsName());

        }
        //返回项的数量
        @Override
        public int getItemCount(){
            return mOrderData == null ? 0 : mOrderData.size();
        }

}
