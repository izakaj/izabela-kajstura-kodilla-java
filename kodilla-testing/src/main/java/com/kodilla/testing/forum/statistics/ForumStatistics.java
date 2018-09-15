package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    int numberOfUsers;
    int numberOfPosts;
    int numberOfComments;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        this.numberOfUsers = statistics.userNames().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();

        averagePostsPerUser = (numberOfUsers != 0 ? (double)numberOfPosts / numberOfUsers : -1);
        averageCommentsPerUser = (numberOfUsers != 0 ? (double)numberOfComments / numberOfUsers : -1);
        averageCommentsPerPost = (numberOfPosts != 0 ? (double)numberOfComments / numberOfPosts : -1);
    }

    public void showStatistics(){
        System.out.println("Number of users: " + numberOfUsers
                + "\nNumber of posts: " + numberOfPosts
                + "\nNumber of comments: " + numberOfComments
                + "\nAverage number of posts per user: " + (averagePostsPerUser != -1 ? averagePostsPerUser : "n/a")
                + "\nAverage number of comments per user: " + (averageCommentsPerUser != -1 ? averageCommentsPerUser : "n/a")
                + "\nAverage number of comments per post: " + (averageCommentsPerPost != -1 ? averageCommentsPerPost : "n/a"));
    }
}
