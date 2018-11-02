package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    final private String taskName;
    final private String where;
    final private String using;
    private boolean isExecuted;

    public DrivingTask(final String taskName, final String where,
                       final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.isExecuted = false;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    public void executeTask() {
        System.out.println("Task: " + taskName + " is executed.");
        isExecuted = true;
    }

    public boolean isTaskExecuted() {
        return isExecuted;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}
