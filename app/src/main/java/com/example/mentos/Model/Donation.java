package com.example.mentos.Model;

public class Donation {
    private  String contents;
    private  String donation;
    private  String end;
    private  String start;
    private  String title;
    private  String uuid;
    private String username;

    public Donation(String contents, String donation, String end, String start, String title, String uuid, String username) {
        this.contents = contents;
        this.donation = donation;
        this.end = end;
        this.start = start;
        this.title = title;
        this.uuid = uuid;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Donation() {
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
