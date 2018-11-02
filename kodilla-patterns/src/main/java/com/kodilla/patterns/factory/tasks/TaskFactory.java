package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Buy Christmas presents",
                        "board game",1.0);
            case PAINTING_TASK:
                return new PaintingTask("Paint my world",
                        "yellow and blue", "my world");
            case DRIVING_TASK:
                return new DrivingTask("Go into Bieszczady",
                        "Bieszczady", "bike");
            default:
                return null;
        }
    }
}
