package gdou.gdou_chb.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import gdou.gdou_chb.data.user.User;
import gdou.gdou_chb.data.user.UsersRepository;
import gdou.gdou_chb.features.user.login.LoginContract;
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
    private final UsersRepository mUsersRepository;

    @NonNull
    private final  LoginContract.View mLoginView;
    private final User mUser;

    private CompositeSubscription mSubscription;

    // TODO:*************************** 便于编译的构造器，需要删除 *********************
    public LoginPresenter(@NonNull LoginContract.View loginView) {
        mLoginView = loginView;
        mUsersRepository = null;
        mUser =null;
    }

    //构建函数 Presenter和View相互保存对方实例
    public LoginPresenter(@Nullable User user, @NonNull UsersRepository usersRepository, @NonNull LoginContract.View loginView) {
        mUser = user;
        mUsersRepository = usersRepository;
        mLoginView = loginView;
        //TODO: RxJava 异步调用的配置的初始化

        mSubscription = new CompositeSubscription();
        mLoginView.setPresenter(this);

    }

    @Override
    public void subscribe() {
        login(mUser);
    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }

    @Override
    public void login(User user) {
        mLoginView.loginprogress(true);
        Subscription subscription = mUsersRepository
                .login(mUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        //TODO:跳转到下一个Activity
//                        mLoginView.showloginstate();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //返回错误信息
                    }

                    @Override
                    public void onNext(User user) {
                        //发送登录操作
                        mLoginView.showloginstate();
                    }
                });
        mSubscription.add(subscription);
    }
}
