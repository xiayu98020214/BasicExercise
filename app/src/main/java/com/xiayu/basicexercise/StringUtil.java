package com.xiayu.basicexercise;

import android.support.annotation.NonNull;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class StringUtil {
    public String originString;

    public StringUtil() {
    }

    public void test(String origin) {
        new StringBuilder(origin).reverse().toString();
    }

    @NonNull
    public static String stringReverse(@NonNull String origin) {
        if (origin == null) {
            throw new NullPointerException("string is null");
        }
        StringBuffer outString = new StringBuffer();
        int size = origin.length();
        for (int i = size - 1; i >= 0; i--) {
            char temp = origin.charAt(i);
            outString.append(temp);
        }
        return outString.toString();
    }


}
