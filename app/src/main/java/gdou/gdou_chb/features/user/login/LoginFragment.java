package gdou.gdou_chb.features.user.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gdou.gdou_chb.R;
import gdou.gdou_chb.UI.MainActivity;
import gdou.gdou_chb.data.user.User;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;
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


    Activity mActivity;

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

        mToolBar = (Toolbar) root.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);
        mToolBar.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolBar);
        //setup
        ButterKnife.bind(this, root);
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
        mPresenter.login(new User(mAccount.getText().toString(),mPassword.getText().toString()));
//        ;startActivity(new Intent(getActivity(),MainActivity.class));
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
                mLoginForm.setVisibility(show?View.VISIBLE:View.GONE);

            }
        });

    }

    @Override
    public void showloginstate() {
        //登录成功
        this.getActivity().startActivity(new Intent(this.getActivity(), MainActivity.class));

    }

    @Override
    public void populateAutoComplete() {
        //TODO 自动完成

    }

}
