package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testAddTask(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        String toDoTask = "take over the world";
        String inProgressTask = "make an evil plan";
        String doneTask = "become a villain";

        //When
        board.addTask(TaskListNames.TO_DO_LIST, toDoTask);
        board.addTask(TaskListNames.IN_PROGRESS_LIST, inProgressTask);
        board.addTask(TaskListNames.DONE_LIST, doneTask);
        String resultToDo = board.getToDoList().showTask(0);
        String resultInProgress = board.getInProgressList().showTask(0);
        String resultDone = board.getDoneList().showTask(0);

        //Then
        Assert.assertEquals("take over the world", resultToDo);
        Assert.assertEquals("make an evil plan", resultInProgress);
        Assert.assertEquals("become a villain", resultDone);
    }
}
