package com.xiayu.basicexercise;

import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class stringReverseTest {
    private static final String TAG = "stringReverseTest";
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void inputNullString(){
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("string is null");
        StringUtil.stringReverse(null);
    }

    @Test
    public void pureEnglish(){
        String src = "abcdef";
        String expect = "fedcba";
        String out = StringUtil.stringReverse(src);
        assertEquals(expect,out);

    }

    @Test
    public void inputEnglishwithBlank(){
        String src = "abcd ef";
        String expect = "fe dcba";
        String out = StringUtil.stringReverse(src);
        assertEquals(expect,out);
    }


    @Test
    public void inputChinese(){
        String src = "我爱你";
        String expect = "你爱我";
        String out = StringUtil.stringReverse(src);
        assertEquals(expect,out);
    }

    @Test
    public void inputChineseEnglish(){
        String src = "我爱love你";
        String expect = "你evol爱我";
        String out = StringUtil.stringReverse(src);
        assertEquals(expect,out);
    }

    public int x;
    public int last()
    {
        x = 1;
        try
        {
            return x;
        }
        finally
        {
            ++x;
        }
    }

    public int get()
    {
        try
        {
            return  1 ;
        }
        finally
        {
            return 2 ;
        }
    }


    @Test
    public void testlast(){
        int y = last(); //y =1  x=2
        int z = get();// z =2;
        Log.e(TAG,"x:"+x+"   y:"+y);
        
    }
}
