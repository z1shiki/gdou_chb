package gdou.gdou_chb.util.MVP;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Z1shiki on 2016/11/21.
 */

public class BaseFragment extends Fragment {
    private static  Context mContext;

    public void jump2Activity(Class cla) {
        this.getActivity().startActivity(new Intent(this.getActivity(), cla));
    }
    public void showToast(){

    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}
