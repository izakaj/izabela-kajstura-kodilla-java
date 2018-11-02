package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    final private String taskName;
    final private String whatToBuy;
    final double quantity;
    private boolean isExecuted;

    public ShoppingTask(final String taskName, final String whatToBuy,
                        final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.isExecuted = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Task: " + taskName + " is executed.");
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }
}
