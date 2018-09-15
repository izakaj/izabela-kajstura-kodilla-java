package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.ForumComment;
import org.junit.*;
import org.junit.rules.TestName;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Rule
    public TestName name = new TestName();

    @Before
    public void before(){
        System.out.println("Starting Test Case: " + name.getMethodName());
    }

    @After
    public void after(){
        System.out.println("Test Case " + name.getMethodName() + " end\n");
    }

    // gdy liczba postów = 0
    @Test
    public void testCalculateAdvStatisticsNoPosts(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        for (int i = 0; i < 9; i++){
            userNamesList.add("aa");
        }
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(30);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double postsPerUser = forumStatistics.getAveragePostsPerUser();
        double commentsPerPost = forumStatistics.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(0, postsPerUser, 0.01);
        Assert.assertEquals(0, commentsPerPost, 0.01);
    }

    /* gdy:
    - liczba postów = 1000,
    - liczba komentarzy > liczba postów
     */

    @Test
    public void testCalculateAdvStatistics1000Posts(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            userNamesList.add("aa");
        }
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1537);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double postsPerUser = forumStatistics.getAveragePostsPerUser();
        double commentsPerPost = forumStatistics.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(100, postsPerUser, 0.01);
        Assert.assertEquals(1.537, commentsPerPost, 0.01);
    }

    // gdy liczba komentarzy < liczba postów
    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            userNamesList.add("aa");
        }
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(153);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double commentsPerPost = forumStatistics.getAverageCommentsPerPost();

        //Then
        Assert.assertEquals(0.153, commentsPerPost, 0.01);
    }

    // gdy liczba komentarzy = 0
    @Test
    public void testCalculateAdvStatisticsNoComments(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            userNamesList.add("aa");
        }
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double commentsPerPost = forumStatistics.getAverageCommentsPerPost();
        double commentsPerUser = forumStatistics.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, commentsPerUser, 0.01);
        Assert.assertEquals(0, commentsPerPost, 0.01);
    }

    // gdy liczba użytkowników = 0
    @Test
    public void testCalculateAdvStatisticsNoUsers(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(20);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double postsPerUser = forumStatistics.getAveragePostsPerUser();
        double commentsPerUser = forumStatistics.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(0, postsPerUser, 0.01);
        Assert.assertEquals(0, commentsPerUser, 0.01);
    }

    // gdy liczba użytkowników = 100
    @Test
    public void testCalculateAdvStatistics100Users(){
        // Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNamesList = new LinkedList<>();
        for (int i = 0; i < 100; i++){
            userNamesList.add("aa");
        }
        when(statisticsMock.userNames()).thenReturn(userNamesList);
        when(statisticsMock.postsCount()).thenReturn(520);
        when(statisticsMock.commentsCount()).thenReturn(130);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics();

        //When
        double postsPerUser = forumStatistics.getAveragePostsPerUser();
        double commentsPerUser = forumStatistics.getAverageCommentsPerUser();

        //Then
        Assert.assertEquals(5.2, postsPerUser, 0.01);
        Assert.assertEquals(1.3, commentsPerUser, 0.01);
    }
}
