package com.kodilla.good.patterns.challenges.food2door;

public final class User {
    private final int userId;
    private final String username;
    private final String address;
    private final String email;

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
