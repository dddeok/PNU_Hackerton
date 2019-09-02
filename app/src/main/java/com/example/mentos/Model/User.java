package com.example.mentos.Model;

public class User {
    private String id;
    private String username;
    private String phonenumber;
    private String email;
    private String job;

    public User(String id, String username, String phonenumber, String email, String job) {
        this.id = id;
        this.username = username;
        this.phonenumber = phonenumber;
        this.email = email;
        this.job = job;
    }


    public User() {
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
