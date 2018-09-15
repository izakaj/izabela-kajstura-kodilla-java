package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
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

        averagePostsPerUser = (numberOfUsers != 0 ? (double)numberOfPosts / numberOfUsers : 0);
        averageCommentsPerUser = (numberOfUsers != 0 ? (double)numberOfComments / numberOfUsers : 0);
        averageCommentsPerPost = (numberOfPosts != 0 ? (double)numberOfComments / numberOfPosts : 0);
    }

    public void showStatistics(){
        System.out.println("Number of users: " + numberOfUsers
                + "\nNumber of posts: " + numberOfPosts
                + "\nNumber of comments: " + numberOfComments
                + "\nAverage number of posts per user: " + String.format("%.2f",averagePostsPerUser)
                + "\nAverage number of comments per user: " + String.format("%.2f", averageCommentsPerUser)
                + "\nAverage number of comments per post: " + String.format("%.2f", averageCommentsPerPost));
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
