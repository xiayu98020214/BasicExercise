package com.xiayu.basicexercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class stringReverseTest {
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
}
