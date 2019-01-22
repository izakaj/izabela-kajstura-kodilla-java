package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(HomeworkToVerify homeworkToVerify) {
        System.out.println(username + ": You received homework to verify from " + homeworkToVerify.getName() +
                "\nTotal no of tasks to verify: " + homeworkToVerify.getTasksToVerify().size());
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
