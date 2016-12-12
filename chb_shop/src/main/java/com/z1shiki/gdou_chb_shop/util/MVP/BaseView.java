package com.z1shiki.gdou_chb_shop.util.MVP;

/**
 * Created by Z1shiki on 2016/11/16.
 */

public interface BaseView<P> {
    void setPresenter(P presenter);
    void jump2Activity(Class cla);
}
