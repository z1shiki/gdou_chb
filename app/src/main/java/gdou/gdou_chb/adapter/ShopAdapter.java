package gdou.gdou_chb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gdou.gdou_chb.R;
import gdou.gdou_chb.model.bean.Shop;

/**
 * Created by Administrator on 2016/12/1/0001.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    //存储context变量
    private Context mContext;
    //创建一个存储商店的成员变量
    private List<Shop> mShopData;//= Datasever.getData(100)
    private LayoutInflater mLayoutInflater;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView shopName;
        //public ImageView shopImg;
        //public TextView distributionFee;
        //public TextView startingPrice;
        //TODO:score

        //构造方法接受每一项的布局作为参数，存储成员变量以便于访问
        public ViewHolder(View itemView){
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.shop_name);
            //shopImg = (ImageView) itemView.findViewById(R.id.shop_img);
            //startingPrice = (TextView) itemView.findViewById(R.id.startingprice);
            //distributionFee = (TextView) itemView.findViewById(R.id.distributionfee);

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
        return new ViewHolder(item);
    }

    //通过holder将数据填充进项
    @Override
    public void onBindViewHolder(ViewHolder holder,int i){
        //得到数据的对象
        Shop shop = mShopData.get(i);
        //设置itemView的内容
        holder.shopName.setText(shop.getShopName());
        //holder.startingPrice.setText(shop.getStartingPrice());
        //holder.distributionFee.setText(shop.getDistributionFee());
       // holder.shopImg.setImageResource(shop.getshopImg));
    }

    //返回项的数量
    @Override
    public int getItemCount(){
        return mShopData == null ? 0 : mShopData.size();
    }
}
