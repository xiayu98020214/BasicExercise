/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xiayu.basicexercise.Mode;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Main entry point for accessing tasks data.
 * <p>
 * For simplicity, only getTasks() and getTask() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 * For example, when a new task is created, it's synchronously stored in cache but usually every
 * operation on database or network should be executed in a different thread.
 */
public interface TasksDataSource<T> {

    interface LoadTasksCallback<E> {
        void onTasksLoaded(E tasks);
        void onDataNotAvailable();
    }

/*    interface GetTaskCallback<T> {
        void onTaskLoaded(T task);
        void onDataNotAvailable();
    }*/

    interface SaveCallback{
        void onSuccess();
        void onFai(String mesg);
    }
    void getTasks(@NonNull LoadTasksCallback callback);
    void getTask(@NonNull String taskId, @NonNull LoadTasksCallback callback);
    void saveTask(@NonNull T task, @NonNull SaveCallback callback);
    void saveTasks(@NonNull List<T> task, @NonNull SaveCallback callback);

}
