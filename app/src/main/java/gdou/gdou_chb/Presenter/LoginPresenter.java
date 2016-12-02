package gdou.gdou_chb.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.contract.LoginContract;
import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.model.impl.UserModelImpl;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class LoginPresenter implements LoginContract.Presenter {

    @NonNull
    private final  LoginContract.View mLoginView;
    private final UserModelImpl mUserModel;


    private CompositeSubscription mSubscription;


    //构建函数 Presenter和View相互保存对方实例
    public LoginPresenter(@Nullable UserModelImpl user,@NonNull LoginContract.View loginView) {
        mUserModel = user;
        mLoginView = loginView;
        //TODO: RxJava 异步调用的配置的初始化

        mSubscription = new CompositeSubscription();
        mLoginView.setPresenter(this);

    }

    @Override
    public void subscribe() {
//        login(mUser);
    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }

    @Override
    public void login(String account,String password) {
        mLoginView.loginprogress(true);
        Subscription subscription =
                mUserModel
                .doLogin(account,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onNext(Result result) {

                               }
                           }
                );
        mSubscription.add(subscription);
    }
}
