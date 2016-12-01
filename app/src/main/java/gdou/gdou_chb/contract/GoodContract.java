package gdou.gdou_chb.contract;

import gdou.gdou_chb.util.MVP.BasePresenter;
import gdou.gdou_chb.util.MVP.BaseView;

/**
 * Created by Z1shiki on 2016/11/29.
 */

public interface GoodContract {

    interface View extends BaseView<Presenter>{
        void changeTrolley();
        void jump2Order();
    }

    interface Presenter extends BasePresenter{
        void add2Trolley();
        void del2Trolley();
        void delAllTrolley();
        void showHand();
    }

}