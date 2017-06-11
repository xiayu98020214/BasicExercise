package com.xiayu.basicexercise.Mode.source.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.xiayu.basicexercise.Mode.TasksDataSource;
import com.xiayu.basicexercise.Mode.WishesData;

import java.util.List;

/**
 * Created by 七喜 on 2017/6/11.
 */

public class SharePreferenceDateSource implements TasksDataSource<WishesData> {

    private static volatile SharePreferenceDateSource sharePreferncesDataSouce;
    private SharedPreferences sharedPreferences;
    private SharePreferenceDateSource(Context context){
        sharedPreferences = context.getSharedPreferences("wishes",Context.MODE_PRIVATE);
    }

    public static SharePreferenceDateSource getSinglton(Context context){
        if(sharePreferncesDataSouce != null ){
            synchronized (SharePreferenceDateSource.class){
                if(sharePreferncesDataSouce != null){
                    sharePreferncesDataSouce = new SharePreferenceDateSource(context);
                }
            }
        }
        return sharePreferncesDataSouce;
    }


    @Override
    public void getTasks(@NonNull LoadTasksCallback callback) {
        String data = sharedPreferences.getString("wishes","");
        List<WishesData> wishesdata = JSON.parseArray(data, WishesData.class);
        callback.onTasksLoaded(wishesdata);
    }

    @Override
    public void getTask(@NonNull String taskId, @NonNull LoadTasksCallback callback) {

    }

    @Override
    public void saveTask(@NonNull WishesData task, @NonNull SaveCallback callback) {
        String data = sharedPreferences.getString("wishes","");
        List<WishesData> wishesdata = JSON.parseArray(data, WishesData.class);
        wishesdata.add(task);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("wishes",JSON.toJSONString(wishesdata));
        boolean flag = editor.commit();
        if(flag){
            callback.onSuccess();
        }else{
            callback.onFai("error");
        }
    }


}
