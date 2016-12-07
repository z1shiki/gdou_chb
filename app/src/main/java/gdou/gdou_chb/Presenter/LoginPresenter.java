package gdou.gdou_chb.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kymjs.rxvolley.rx.Result;

import gdou.gdou_chb.activity.HomeActivity;
import gdou.gdou_chb.contract.LoginContract;
import gdou.gdou_chb.model.bean.ResultBean;
import gdou.gdou_chb.model.bean.User;
import gdou.gdou_chb.model.impl.BaseModelImpl;
import gdou.gdou_chb.model.impl.UserModelImpl;
import gdou.gdou_chb.util.GsonUtils;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
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
    public void login(User user) {
        mLoginView.loginprogress(true);
        Subscription subscription =
                mUserModel
                        .doLogin(user)
                        .map(new Func1<Result, String>() {

                            @Override
                            public String call(Result result) {
                                return new String(result.data);
                            }
                        } )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<String>() {
                                       @Override
                                       public void onCompleted() {
                                           Log.d("Login", "succ");
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           mLoginView.jump2Activity(HomeActivity.class);
                                           Log.d("Login","error");
                                       }

                                       @Override
                                       public void onNext(String string) {
                                           ResultBean resultBean = GsonUtils.getResultBeanByJson(string);
                                           User user = GsonUtils.getBeanFromResultBean(resultBean, "user",User.class);
                                           BaseModelImpl.user = user;
                                       }
                                   }
                        );
        mSubscription.add(subscription);
    }
}