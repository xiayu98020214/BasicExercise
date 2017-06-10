package com.xiayu.basicexercise.Mode;

import java.io.Serializable;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class WishesData implements Serializable{

    String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WishesData{" +
                "content='" + content + '\'' +
                '}';
    }
}
