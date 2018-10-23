package com.kodilla.spring.portfolio;

public enum TaskListNames {
    TO_DO_LIST("toDoList"),
    IN_PROGRESS_LIST("inProgressList"),
    DONE_LIST("doneList");

    private String listName;

    TaskListNames(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

}
