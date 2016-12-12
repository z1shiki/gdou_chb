package com.z1shiki.gdou_chb_shop.util.MVP;

import android.app.Fragment;
import android.content.Intent;

/**
 * Created by Z1shiki on 2016/11/21.
 */

public class BaseFragment extends Fragment {

    public void jump2Activity(Class cla) {
        this.getActivity().startActivity(new Intent(this.getActivity(), cla));
    }

    public void DontLookBackAgain(Class cla){
        this.getActivity().startActivity(new Intent(this.getActivity(), cla));
        this.getActivity().finish();
    }

    public void showToast(){

    }
//    public void switchContent(Fragment from, Fragment to) {
//        if (mContent != to) {
//            mContent = to;
//            FragmentTransaction transaction = mFragmentMan.beginTransaction().setCustomAnimations(
//                    android.R.anim.fade_in, R.anim.slide_out);
//            if (!to.isAdded()) {	// 先判断是否被add过
//                transaction.hide(from).add(R.id.content_frame, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
//            } else {
//                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
//            }
//        }
//    }
}
