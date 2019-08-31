package com.example.mentos.Model;

public class Donation {
    private  String contents;
    private  String donation;
    private  String end;
    private  String start;
    private  String title;
    private  String uuid;

    public Donation(String contents, String donation, String end, String start, String title, String uuid) {
        this.contents = contents;
        this.donation = donation;
        this.end = end;
        this.start = start;
        this.title = title;
        this.uuid = uuid;
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
