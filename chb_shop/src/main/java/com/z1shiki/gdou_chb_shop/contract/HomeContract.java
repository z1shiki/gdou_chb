package com.z1shiki.gdou_chb_shop.contract;

import com.z1shiki.gdou_chb_shop.model.bean.Orders;
import com.z1shiki.gdou_chb_shop.model.bean.Shop;
import com.z1shiki.gdou_chb_shop.util.MVP.BasePresenter;
import com.z1shiki.gdou_chb_shop.util.MVP.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Z1shiki on 2016/11/25.
 */

public interface HomeContract {

    interface ShopView extends BaseView<ShopPresenter> {
        void setLocation(String string);//显示地址的方法，参数是地址
        void changeShoplist(List<Shop> shopList);//显示商店列表的方法 参数是商店列表
        void choiceShop();//进入GoodActivity  Intent传 参数是ShopName
        void showSnackbar();
}
    interface OrderView extends BaseView<OrderPresenter>{
        void setAdapter(ArrayList<Orders> list);
        void Datachanged();

    }
    interface UserCenterView extends BaseView<UserCenterPresenter>{

    }

    interface ShopPresenter extends BasePresenter {
        void getGPS();
        void changelocation();
        void doSerach();
        void getShopList();

    }

    interface UserCenterPresenter extends BasePresenter{
    }

    interface OrderPresenter extends BasePresenter{
        void initData();
        void doenOrder(Long orderId);
        void backOrder(Long orderId);
    }

}