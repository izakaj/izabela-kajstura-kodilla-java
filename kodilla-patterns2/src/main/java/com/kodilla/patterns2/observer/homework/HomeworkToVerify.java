package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkToVerify implements Observable {
    private final List<Observer> observers;
    private final List<String> tasksToVerify;
    private final String name;

    public HomeworkToVerify(String name) {
        observers = new ArrayList<>();
        tasksToVerify = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasksToVerify.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getTasksToVerify() {
        return tasksToVerify;
    }

    public String getName() {
        return name;
    }
}
