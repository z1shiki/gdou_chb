package com.z1shiki.gdou_chb_shop.util.Java;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Z1shiki on 2016/11/21.
 */

public class ActivityUtils {
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId){
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(!fragment.isAdded()){transaction.add(frameId,fragment);}
        transaction.commit();
    }
    public static void HideFragment(@NonNull FragmentManager fragmentManager,
                                    @NonNull Fragment fragment){
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }
    public static void ShowFragment(@NonNull FragmentManager fragmentManager,
                                    @NonNull Fragment fragment,@NonNull int frameId){
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        addFragmentToActivity(fragmentManager,fragment,frameId);
        transaction.show(fragment);
        transaction.commit();
    }
    public static void replaceFragment(FragmentManager fragmentManager,
                                       Fragment fragment,int frameId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId,fragment);
        transaction.commit();
    }
}
