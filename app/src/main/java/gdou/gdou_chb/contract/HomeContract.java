package gdou.gdou_chb.contract;

import gdou.gdou_chb.util.MVP.BasePresenter;
import gdou.gdou_chb.util.MVP.BaseView;

/**
 * Created by Z1shiki on 2016/11/25.
 */

public interface HomeContract {

    interface ShopView extends BaseView<Presenter>{
        void setLocation();//显示地址的方法，参数是地址
        void changeShoplist();//显示商店列表的方法 参数是商店列表
        void choiceShop();//进入GoodActivity  Intent传 参数是ShopName
}
    interface OrderView extends BaseView<Presenter>{

    }
    interface UserCenterView extends BaseView<Presenter>{

    }

    interface Presenter extends BasePresenter{
        void initAmap();
        void getGPS();
        void changelocation();
        void doSerach();

    }

}