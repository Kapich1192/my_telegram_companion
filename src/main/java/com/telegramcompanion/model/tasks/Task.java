package com.telegramcompanion.model.tasks;

import lombok.Data;


import java.util.ArrayList;
public class Task {
    private Long id;
    private String title;
    private String task;
    private ArrayList<Task> subTasks = new ArrayList<>();
    public Task(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTask() {
        return task;
    }

    public ArrayList<Task> getSubTasks() {
        return subTasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setSubTasks(ArrayList<Task> subTasks) {
        this.subTasks = subTasks;
    }
}
