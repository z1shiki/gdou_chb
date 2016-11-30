package gdou.gdou_chb.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gdou.gdou_chb.contract.LoginContract;
import gdou.gdou_chb.data.bean.User;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class LoginPresenter implements LoginContract.Presenter {

    @NonNull
    private final  LoginContract.View mLoginView;
    private final User mUser;
    private final String mUsername;

    private CompositeSubscription mSubscription;


    //构建函数 Presenter和View相互保存对方实例
    public LoginPresenter(String username,@Nullable User usermodel,@NonNull LoginContract.View loginView) {
        mUsername = username;
        mUser = usermodel;
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
        mLoginView.showloginstate();
    }

//    @Override
//    public void login(User user) {
//        mLoginView.loginprogress(true);
//        Subscription subscription =
//                UserModel
//               .login(mUser)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<User>() {
//                    @Override
//                    public void onCompleted() {
//                        //TODO:跳转到下一个Activity
////                        mLoginView.showloginstate();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //返回错误信息
//                    }
//
//                    @Override
//                    public void onNext(User user) {
//                        //发送登录操作
//                        mLoginView.showloginstate();
//                    }
//                });
//        mSubscription.add(subscription);
//    }
}
