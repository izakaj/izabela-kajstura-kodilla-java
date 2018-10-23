package com.kodilla.spring.portfolio;

public final class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addTask(TaskListNames listName, String taskName){
        System.out.println(listName);
        switch (listName){
            case DONE_LIST: doneList.addTask(taskName); break;
            case TO_DO_LIST: toDoList.addTask(taskName); break;
            case IN_PROGRESS_LIST: inProgressList.addTask(taskName); break;
            default:
                System.out.println("Cannot add task to any list");
        }

    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    @Override
    public String toString() {
        return "Board{" +
                "toDoList=" + toDoList +
                ", inProgressList=" + inProgressList +
                ", doneList=" + doneList +
                '}';
    }
}
