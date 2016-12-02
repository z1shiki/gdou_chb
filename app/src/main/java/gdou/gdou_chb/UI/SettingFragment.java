package gdou.gdou_chb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gdou.gdou_chb.R;
import gdou.gdou_chb.activity.AboutActivity;
import gdou.gdou_chb.activity.ReportActivity;
import gdou.gdou_chb.contract.SettingContract;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class SettingFragment extends BaseFragment implements SettingContract.View {

    @BindView(R.id.report_view)
    TextView reportView;
    @BindView(R.id.about_view)
    TextView aboutView;
    private SettingContract.Presenter mPresenter;

    public SettingFragment() { //Requires empty public constructor
    }

    public static SettingFragment newInstanceState() {
        return new SettingFragment();
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
    public void setPresenter(@NonNull SettingContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.setting_frag, container, false);


        //setup
        ButterKnife.bind(this, root);


        return root;
    }


    @OnClick({R.id.report_view, R.id.about_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.report_view:
                jump2Activity(ReportActivity.class);
                break;
            case R.id.about_view:
                jump2Activity(AboutActivity.class);
                break;
        }
    }
}