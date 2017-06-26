package com.xiayu.basicexercise.Mode;

import java.io.Serializable;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class WishesData implements Serializable{

    String content;
    public float x;
    public float y;

    public float getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public float scaleFactor;

    public WishesData(){
    }

    public WishesData(String comtent, float x, float y){
        this.content = content;
        this.x=x;
        this.y=y;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "WishesData{" +
                "content='" + content + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
