package gdou.gdou_chb.presenter;

import gdou.gdou_chb.contract.HomeContract;

/**
 * Created by Z1shiki on 2016/12/5.
 */

public class OrderPresenter implements HomeContract.OrderPresenter {
    private final HomeContract.OrderView mOrderView;
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    public OrderPresenter(HomeContract.OrderView view) {
        mOrderView = view;
        mOrderView.setPresenter(this);
    }
}
