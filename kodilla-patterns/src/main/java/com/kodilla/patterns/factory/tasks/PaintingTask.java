package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {
    final private String taskName;
    final private String color;
    final private String whatToPaint;
    private boolean isExecuted;

    public PaintingTask(final String taskName, final String color,
                        final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.isExecuted = false;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        System.out.println("Task: " + taskName + " is executed.");
        isExecuted = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }
}
