package gdou.gdou_chb.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import gdou.gdou_chb.R;
import gdou.gdou_chb.contract.AboutContract;
import gdou.gdou_chb.util.MVP.BaseFragment;

/**
 * Created by Administrator on 2016/11/28/0028.
 */

public class AboutFragment extends BaseFragment implements AboutContract.View{

    private AboutContract.Presenter mPresenter;

    public AboutFragment() { //Requires empty public constructor
    }

    public static AboutFragment newInstanceState() {
        return new AboutFragment();
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

    public void setPresenter(@NonNull AboutContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.about_frag, container, false);
        setHasOptionsMenu(true);
//        mAboutToolBar.setTitle("");
//        ((AppCompatActivity) getActivity()).setSupportActionBar(mAboutToolBar);
        //setup
        ButterKnife.bind(this, root);
        return root;
    }

}



