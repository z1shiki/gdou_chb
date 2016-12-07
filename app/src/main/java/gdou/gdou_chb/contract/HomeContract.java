package gdou.gdou_chb.contract;

import java.util.List;

import gdou.gdou_chb.model.bean.Shop;
import gdou.gdou_chb.util.MVP.BasePresenter;
import gdou.gdou_chb.util.MVP.BaseView;

/**
 * Created by Z1shiki on 2016/11/25.
 */

public interface HomeContract {

    interface ShopView extends BaseView<ShopPresenter>{
        void setLocation();//显示地址的方法，参数是地址
        void changeShoplist(List<Shop> shopList);//显示商店列表的方法 参数是商店列表
        void choiceShop();//进入GoodActivity  Intent传 参数是ShopName
}
    interface OrderView extends BaseView<OrderPresenter>{

    }
    interface UserCenterView extends BaseView<UserCenterPresenter>{

    }

    interface ShopPresenter extends BasePresenter{
        void initAmap();
        void getGPS();
        void changelocation();
        void doSerach();
        void getShopList();

    }

    interface UserCenterPresenter extends BasePresenter{
    }

    interface OrderPresenter extends BasePresenter{
    }

}