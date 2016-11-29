package gdou.gdou_chb.contract;

import gdou.gdou_chb.util.MVP.BasePresenter;
import gdou.gdou_chb.util.MVP.BaseView;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public interface MapContract {

    interface View extends BaseView<Presenter>{
    }

    interface Presenter extends BasePresenter{
    }

}