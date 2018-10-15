package com.kodilla.good.patterns.challenges.food2door;

public class User {
    private int userId;
    private String username;
    private String address;
    private String email;

    public User(int userId, String username, String address, String email) {
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
