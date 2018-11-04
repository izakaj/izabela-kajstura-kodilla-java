package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskClass.SHOPPING_TASK);
        String whatToBuy = ((ShoppingTask) shoppingTask).getWhatToBuy();
        boolean isExecuted = shoppingTask.isTaskExecuted();

        //Then
        Assert.assertEquals("Buy Christmas presents", shoppingTask.getTaskName());
        Assert.assertEquals("board game", whatToBuy);
        Assert.assertEquals(false, isExecuted);
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskClass.PAINTING_TASK);
        boolean isExecuted = paintingTask.isTaskExecuted();
        String color = ((PaintingTask) paintingTask).getColor();

        //Then
        Assert.assertEquals("Paint my world", paintingTask.getTaskName());
        Assert.assertEquals("yellow and blue", color);
        Assert.assertEquals(false, isExecuted);
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskClass.DRIVING_TASK);
        boolean isExecuted = drivingTask.isTaskExecuted();
        String where = ((DrivingTask) drivingTask).getWhere();

        //Then
        Assert.assertEquals("Go into Bieszczady", drivingTask.getTaskName());
        Assert.assertEquals("Bieszczady", where);
        Assert.assertEquals(false, isExecuted);
    }

    @Test
    public void testShoppingTaskExecution() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskClass.SHOPPING_TASK);
        boolean isExecutedBefore = shoppingTask.isTaskExecuted();
        shoppingTask.executeTask();
        boolean isExecutedAfter = shoppingTask.isTaskExecuted();
        //Then
        Assert.assertFalse(isExecutedBefore);
        Assert.assertTrue(isExecutedAfter);
    }

    @Test
    public void testPaintingTaskExecution() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskClass.PAINTING_TASK);
        boolean isExecutedBefore = paintingTask.isTaskExecuted();
        paintingTask.executeTask();
        boolean isExecutedAfter = paintingTask.isTaskExecuted();
        //Then
        Assert.assertFalse(isExecutedBefore);
        Assert.assertTrue(isExecutedAfter);
    }

    @Test
    public void testDrivingTaskExecution() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskClass.DRIVING_TASK);
        boolean isExecutedBefore = drivingTask.isTaskExecuted();
        drivingTask.executeTask();
        boolean isExecutedAfter = drivingTask.isTaskExecuted();
        //Then
        Assert.assertFalse(isExecutedBefore);
        Assert.assertTrue(isExecutedAfter);
    }
}
