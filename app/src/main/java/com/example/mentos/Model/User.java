package com.example.mentos.Model;

public class User {
    private String id;
    private String username;
    private String phonenumber;

    public User(String id, String username, String phonenumber) {
        this.id = id;
        this.username = username;
        this.phonenumber = phonenumber;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
