package gdou.gdou_chb.util.MVP;

import android.app.Fragment;
import android.content.Intent;

/**
 * Created by Z1shiki on 2016/11/21.
 */

public class BaseFragment extends Fragment {

    public void jump2Activity(Class cla) {
        this.getActivity().startActivity(new Intent(this.getActivity(), cla));
    }
    public void showToast(){

    };

}
