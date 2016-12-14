package gdou.gdou_chb.util.MVP;

import android.app.Activity;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public interface BaseView<P> {
    void setPresenter(P presenter);
    void jump2Activity(Class cla);
    void DontLookBackAgain(Class cla);
    Activity getActivity();
}
