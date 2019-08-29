package com.example.mentos.Model;

public class Content {
    private String title;
    private String donation;
    private String startDate;
    private String endDate;
    private String contents;

    public Content(String title, String donation, String startDate, String endDate, String contents) {
        this.title = title;
        this.donation = donation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contents = contents;
    }

    public Content() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
