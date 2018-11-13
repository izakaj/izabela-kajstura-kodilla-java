package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LIST_NAME = "In progress";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, "Save the world");
        taskListDao.save(taskList);
        System.out.println(taskListDao.count());
        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(LIST_NAME);

        //Then
        Assert.assertEquals(1, readTaskLists.size());

        //CleanUp
        int id = taskList.getId();

        taskListDao.findAll().forEach(c -> taskListDao.delete(c.getId()));
        System.out.println(taskListDao.count());
    }

}
