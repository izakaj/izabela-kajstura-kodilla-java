package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(){
        forumUserList.add(new ForumUser(1, "Alfred", 'M',
                LocalDate.of(1975, 12, 13), 5));
        forumUserList.add(new ForumUser(2, "Beniamin", 'M',
                LocalDate.of(1980, 1, 27), 0));
        forumUserList.add(new ForumUser(3, "Celina", 'F',
                LocalDate.of(1999, 2, 15), 3));
        forumUserList.add(new ForumUser(4, "Dobromir", 'M',
                LocalDate.of(2005, 3, 3), 1));
        forumUserList.add(new ForumUser(5, "Ermengarda", 'F',
                LocalDate.of(2007, 4, 1), 7));
        forumUserList.add(new ForumUser(6, "Felicjan", 'M',
                LocalDate.of(1988, 5, 3), 10));
        forumUserList.add(new ForumUser(7, "Gerhard", 'M',
                LocalDate.of(1988, 6, 23), 0));
        forumUserList.add(new ForumUser(8, "Henrietta", 'F',
                LocalDate.of(1997, 7, 14), 9));
        forumUserList.add(new ForumUser(9, "Izydor", 'M',
                LocalDate.of(1996, 8, 17), 3));
        forumUserList.add(new ForumUser(10, "Jaromir", 'M',
                LocalDate.of(2008, 9, 18), 4));
    }

    public List<ForumUser> getUserList() {
        return forumUserList;
    }
}
