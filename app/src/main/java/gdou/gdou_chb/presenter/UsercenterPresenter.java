package gdou.gdou_chb.presenter;

import gdou.gdou_chb.contract.HomeContract;

/**
 * Created by Z1shiki on 2016/12/5.
 */

public class UsercenterPresenter implements HomeContract.UserCenterPresenter {
    private final HomeContract.UserCenterView mUserCenterView;

    public UsercenterPresenter(HomeContract.UserCenterView userCenterView) {
        mUserCenterView = userCenterView;
        mUserCenterView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
