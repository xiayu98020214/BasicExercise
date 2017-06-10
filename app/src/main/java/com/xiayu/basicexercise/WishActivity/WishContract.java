package com.xiayu.basicexercise.WishActivity;

import com.xiayu.basicexercise.Mode.WishesData;
import com.xiayu.basicexercise.base.BasePresenter;
import com.xiayu.basicexercise.base.BaseView;

import java.util.List;

/**
 * Created by 七喜 on 2017/6/10.
 */

public class WishContract {

    interface View extends BaseView<Present>{
        void showWishes(List<WishesData> data);

    }

    interface Present extends BasePresenter{

        void saveWishes(List<WishesData> data);
    }



}
