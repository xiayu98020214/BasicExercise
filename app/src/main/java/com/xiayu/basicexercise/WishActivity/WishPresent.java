package com.xiayu.basicexercise.WishActivity;

import com.xiayu.basicexercise.Mode.TasksDataSource;
import com.xiayu.basicexercise.Mode.WishesData;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class WishPresent implements WishContract.Present {

    TasksDataSource<WishesData> wishSource;
    WishContract.View wishesView;

    public WishPresent(TasksDataSource<WishesData> source, WishContract.View view) {
        wishSource = checkNotNull(source);
        wishesView = checkNotNull(view);
        wishesView.setPresenter(this);
    }


    @Override
    public void saveWishes(List<WishesData> data) {
        wishSource.saveTasks(data, new TasksDataSource.SaveCallback() {
            @Override
            public void onSuccess() {
                wishesView.showSaveSuc();
            }

            @Override
            public void onFai(String mesg) {

            }
        });
    }

    @Override
    public void start() {
        WishesData data = new WishesData();
        data.setContent("你最棒");
        List<WishesData> list = new ArrayList<>();
        list.add(data);
        wishSource.getTasks(new TasksDataSource.LoadTasksCallback<List<WishesData>>() {
            @Override
            public void onTasksLoaded(List<WishesData> tasks) {
                if (tasks == null || tasks.size() == 0) {
                    wishesView.showNoWish();
                } else {
                    wishesView.showWishes(tasks);
                }
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

    }

}
