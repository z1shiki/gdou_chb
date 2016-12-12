package com.z1shiki.gdou_chb_shop.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.z1shiki.gdou_chb_shop.R;
import com.z1shiki.gdou_chb_shop.contract.LoginContract;
import com.z1shiki.gdou_chb_shop.model.bean.User;
import com.z1shiki.gdou_chb_shop.util.Java.BaseActivity;
import com.z1shiki.gdou_chb_shop.util.MVP.BaseFragment;
import com.z1shiki.gdou_chb_shop.util.SnackbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Z1shiki on 2016/11/16.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {

    @BindView(R.id.login_progress)
    ProgressBar mLoginProgress;
    @BindView(R.id.login_form)
    ScrollView mLoginForm;
    @BindView(R.id.account)
    AutoCompleteTextView mAccount;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.sign_in_btn)
    Button mSignInBtn;
    @BindView(R.id.sign_up_link)
    TextView mSignUp;
    @BindView(R.id.forget_link)
    TextView mForget;


    private LoginContract.Presenter mPresenter;

    public LoginFragment() { //Requires empty public constructor
    }

    public static LoginFragment newInstanceState() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_frag, container, false);
        setHasOptionsMenu(true);
        //setup
        ButterKnife.bind(this, root);

        Toolbar mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        ((BaseActivity)getActivity()).setSupportActionBar(mToolbar);

        populateAutoComplete();
        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        return root;
        }

    @OnClick(R.id.sign_in_btn)
    public void onClick() {
        doLogin();
//        ;startActivity(new Intent(getActivity(),MainActivity.class));
    }

    private void doLogin() {
        mPresenter.login(new User(mAccount.getText().toString(),mPassword.getText().toString()));
    }

    @Override
    public void showSnackbar() {
        SnackbarUtil.LongSnackbar(getActivity().findViewById(R.id.contentFrame),
                "登录失败",4)
                .show();
    }

    //登陆的动画
    @Override
    public void loginprogress(final boolean show) {

        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLoginForm.setVisibility(show ? View.GONE:View.VISIBLE);
        mLoginForm.animate().setDuration(shortAnimTime).alpha(show ? 0:1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginForm.setVisibility(show?View.GONE:View.VISIBLE);
            }
        });

        mLoginProgress.setVisibility(show?View.VISIBLE:View.GONE);
        mLoginProgress.animate().setDuration(shortAnimTime).alpha(show?1:0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginProgress.setVisibility(show?View.VISIBLE:View.GONE);

            }
        });

    }


    @Override
    public void populateAutoComplete() {
        //TODO 自动完成

    }

}
