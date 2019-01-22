package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {

    @Test
    public void testUpdate() {
        //Given
        HomeworkToVerify anakinSkywalkerHomework = new AnakinSkywalkerHomework("Anakin Skywalker");
        HomeworkToVerify lukeSkywalkerHomework = new LukeSkywalkerHomework("Luke Skywalker");
        HomeworkToVerify randomJediHomework = new RandomJediHomework("Random Jedi");
        Mentor obiWanKenobi = new Mentor("Obi Wan Kenobi");
        Mentor yoda = new Mentor("Yoda");
        anakinSkywalkerHomework.registerObserver(obiWanKenobi);
        lukeSkywalkerHomework.registerObserver(obiWanKenobi);
        lukeSkywalkerHomework.registerObserver(yoda);
        randomJediHomework.registerObserver(yoda);

        //When
        anakinSkywalkerHomework.addTask("Become the greatest jedi ever");
        anakinSkywalkerHomework.addTask("Break all the rules");
        anakinSkywalkerHomework.addTask("Join the dark side");
        lukeSkywalkerHomework.addTask("Save the world");
        lukeSkywalkerHomework.addTask("Destroy the Death Star");
        randomJediHomework.addTask("Survive");

        //Then
        assertEquals(5, obiWanKenobi.getUpdateCount());
        assertEquals(3, yoda.getUpdateCount());
    }

}