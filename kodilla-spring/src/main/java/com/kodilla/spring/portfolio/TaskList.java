package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class TaskList {
    private List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(String taskName){
        return tasks.add(taskName);
    }

    public String showTask(int number){
        return tasks.get(number);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
