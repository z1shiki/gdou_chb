package gdou.gdou_chb.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.contract.GoodContract;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public class GoodFragment extends BaseFragment implements GoodContract.View {

    private GoodContract.Presenter mPresenter;

    public GoodFragment() { //Requires empty public constructor
    }

    public static GoodFragment newInstanceState() {
        return new GoodFragment();
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
    public void setPresenter(@NonNull GoodContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.good_frag, container, false);



        //setup
        ButterKnife.bind(this, root);



        return root;
    }


}