package gdou.gdou_chb.presenter;

import gdou.gdou_chb.contract.GoodContract;

/**
 * Created by Z1shiki on 2016/11/30.
 */
public class GoodPresenter implements GoodContract.Presenter {
    private final GoodContract.View mGoodView;


    public GoodPresenter(GoodContract.View goodView) {
        mGoodView = goodView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
