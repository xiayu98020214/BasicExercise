package com.xiayu.basicexercise;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by 七喜 on 2017/6/10.
 */

public class ActivityUtil {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {

        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(frameId, fragment);
        ft.commit();
    }
}
