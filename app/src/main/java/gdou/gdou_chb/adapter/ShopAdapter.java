package gdou.gdou_chb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import gdou.gdou_chb.R;
import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.model.impl.BaseModelImpl;

/**
 * Created by Administrator on 2016/12/1/0001.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    //存储context变量
    private Context mContext;
    //创建一个存储商店的成员变量
    private List<Shop> mShopData;//= Datasever.getData(100)
    private LayoutInflater mLayoutInflater;
    private MyItemClickListener mItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView shopName;
        public ImageView shopImg;
        public TextView distributionFee;
        public TextView startingPrice;
        private MyItemClickListener mListener;
        //TODO:score

        //构造方法接受每一项的布局作为参数，存储成员变量以便于访问
        public ViewHolder(View itemView, MyItemClickListener mListener){
            super(itemView);
            this.mListener = mListener;
            itemView.setOnClickListener(this);
            shopName = (TextView) itemView.findViewById(R.id.shop_name);
            shopImg = (ImageView) itemView.findViewById(R.id.shop_img);
            startingPrice = (TextView) itemView.findViewById(R.id.startingprice);
            distributionFee = (TextView) itemView.findViewById(R.id.distributionfee);

        }

        @Override
        public void onClick(View view) {
            Log.d("点击了", "onClick: " + getPosition() + "");
            if (mListener != null)
                mListener.onItemClick(view, getPosition() );
        }
    }

    //为了方便的访问Context变量
    public ShopAdapter(Context context, List<Shop> datas){
        this.mContext = context;
        this.mShopData = datas;
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
        View item = mLayoutInflater.inflate(R.layout.item_shop, parent, false);

        //返回一个holder实例
        return new ViewHolder(item, mItemClickListener);
    }

    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    //通过holder将数据填充进项
    @Override
    public void onBindViewHolder(ViewHolder holder,int i){
        //得到数据的对象
        Shop shop = mShopData.get(i);
        //设置itemView的内容
        holder.shopName.setText(shop.getShopName());
        holder.startingPrice.setText(shop.getStartingPrice() + "");
        holder.distributionFee.setText(shop.getDistributionFee() + "");
        Glide
                .with(mContext)
                .load(BaseModelImpl.Service_URL + BaseModelImpl.IMAGE_URL + shop.getShopImg())
                .placeholder(R.mipmap.type_one_sunny)
                .override(80,80)
                .into(holder.shopImg);
    }

    //返回项的数量
    @Override
    public int getItemCount(){
        return mShopData == null ? 0 : mShopData.size();
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int postion);
    }

}
