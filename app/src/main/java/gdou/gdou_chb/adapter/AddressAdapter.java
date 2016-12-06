package gdou.gdou_chb.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.model.bean.Address;
/**
 * Created by AC on 2016/11/30.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder>{

    private Context mContext;
    private List<Address> mAddressList;
    private LayoutInflater mInflater;

    //自定义ViewHolder类
    class AddressViewHolder extends RecyclerView.ViewHolder{

        CardView mCon;
        TextView mConName;
        TextView mConPhone;
        TextView mConAddress;

        public AddressViewHolder(View itemView) {
            super(itemView);
            mCon = (CardView) itemView.findViewById(R.id.con);
            mConName = (TextView) itemView.findViewById(R.id.con_name);
            mConPhone = (TextView) itemView.findViewById(R.id.con_phone);
            mConAddress = (TextView) itemView.findViewById(R.id.con_address);
            ButterKnife.bind(this, itemView);
        }
    }

    //构造函数，将数据赋值给成员变量
    public AddressAdapter( List<Address>addressList){
        this.mAddressList = addressList;
        mInflater = LayoutInflater. from(mContext);
    }

    //将布局进行绑定
    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new AddressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.consignee_item, parent, false));
    }

    //绑定数据
    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {

       /* AddressViewHolder.mConName.setText(mAddressList.get(position).getName());
        AddressViewHolder.mConPhone.setText(mAddressList.get(position).getPhone());
        AddressViewHolder.mConAddress.setText(mAddressList.get(position).getAddress());
        //设置点击事件
        AddressViewHolder.mCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(context,NewsActivity.class);
                //intent.putExtra("News",newses.get(j));
                //context.startActivity(intent);
            }
        });*/
    }
    //获得数据大小
    @Override
    public int getItemCount() {
        return mAddressList.size();
    }

    /*public static class  BottomEntity
    {
        public  BottomEntity(String title)
        {
            this.title = title;
        }
        public String title;

    }*/

}
