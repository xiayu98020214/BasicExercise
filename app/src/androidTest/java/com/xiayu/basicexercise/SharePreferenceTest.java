package com.xiayu.basicexercise;

import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.xiayu.basicexercise.Mode.TasksDataSource;
import com.xiayu.basicexercise.Mode.WishesData;
import com.xiayu.basicexercise.Mode.source.local.SharePreferenceDateSource;
import com.xiayu.basicexercise.WishActivity.WishActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

/**
 * Created by 七喜 on 2017/6/11.
 */
public class SharePreferenceTest {

    private static final String TAG = "SharePreferenceTest";
    SharePreferenceDateSource sharePreferenceDateSource;

    @Rule
    public ActivityTestRule<WishActivity> mActivityRule = new ActivityTestRule<WishActivity>(WishActivity.class);

    @Before
    public void init(){
        sharePreferenceDateSource = SharePreferenceDateSource.getSinglton(mActivityRule.getActivity());
    }

    @Test
    public void saveAndReadWish(){
        List<WishesData> datas;
        WishesData data = new WishesData();
        data.setContent("你最好");
        sharePreferenceDateSource.saveTask(data, new TasksDataSource.SaveCallback() {
            @Override
            public void onSuccess() {
                Log.e(TAG, "onSuccess");
                sharePreferenceDateSource.getTasks(new TasksDataSource.LoadTasksCallback<WishesData>() {
                    @Override
                    public void onTasksLoaded(WishesData tasks) {
                    //    assertEquals()
                    }

                    @Override
                    public void onDataNotAvailable() {

                    }
                });
            }

            @Override
            public void onFai(String mesg) {

            }
        });


    }
}