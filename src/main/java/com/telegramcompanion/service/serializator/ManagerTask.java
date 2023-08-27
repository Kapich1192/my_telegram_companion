package com.telegramcompanion.service.serializator;

import com.telegramcompanion.model.tasks.Task;

public interface ManagerTask {
    default void saveTask(Task task) {

    }

    default void getTask(Long id) {

    }

    default void getAllTask() {

    }

}
