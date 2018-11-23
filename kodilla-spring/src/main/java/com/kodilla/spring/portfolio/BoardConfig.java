package com.kodilla.spring.portfolio;

import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDo")
    private TaskList toDoList;

    @Bean
    public Board getBoard(){
        return new Board(toDoList, getInProgressTaskList(), getDoneTaskList());
    }

    @Bean(name = "toDo")
    public TaskList getToDoTaskList(){
        return new TaskList();
    }

    @Bean(name = "inProgress")
    public TaskList getInProgressTaskList(){
        return new TaskList();
    }

    @Bean(name = "done")
    public TaskList getDoneTaskList(){
        return new TaskList();
    }

}
