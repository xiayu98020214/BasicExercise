package com.xiayu.basicexercise.WishActivity;

import com.google.common.collect.Lists;
import com.xiayu.basicexercise.Mode.TasksDataSource;
import com.xiayu.basicexercise.Mode.WishesData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by 七喜 on 2017/6/14.
 */
public class WishPresentTest {

    @Mock
    TasksDataSource<WishesData> dataSource;

    @Mock
    private WishContract.View wishView ;

    @Captor
    private ArgumentCaptor<TasksDataSource.LoadTasksCallback> mLoadTasksCallbackCaptor;

    private WishPresent mWishPresent;

    private static List<WishesData> WISHESDATA;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mWishPresent = new WishPresent(dataSource, wishView);
        // The presenter won't update the view unless it's active.
        when(wishView.isActive()).thenReturn(true);
        WISHESDATA = Lists.newArrayList(new WishesData("good"),new WishesData("bad"),new WishesData("between"),new WishesData("days"),
                new WishesData("months")
             );
    }

    @Test
    public void createPresenter_setsThePresenterToView() {
        // Get a reference to the class under test
        mWishPresent = new WishPresent(dataSource, wishView);

        // Then the presenter is set to the view
        verify(wishView).setPresenter(mWishPresent);
    }

    @Test
    public void loadAllTasksFromRepositoryAndLoadIntoView() {
        // Given an initialized TasksPresenter with initialized tasks
        // When loading of Tasks is requested
        mWishPresent.start();

        // Callback is captured and invoked with stubbed tasks
        verify(dataSource).getTasks(mLoadTasksCallbackCaptor.capture());
        mLoadTasksCallbackCaptor.getValue().onTasksLoaded(WISHESDATA);

        // Then progress indicator is shown
        InOrder inOrder = inOrder(wishView);
       // inOrder.verify(wishView).setLoadingIndicator(true);
        // Then progress indicator is hidden and all tasks are shown in UI
       // inOrder.verify(wishView).setLoadingIndicator(false);
        ArgumentCaptor<List> showTasksArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(wishView).showWishes(showTasksArgumentCaptor.capture());
        assertEquals(showTasksArgumentCaptor.getValue().size(),5);
    }


}