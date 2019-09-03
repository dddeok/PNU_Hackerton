package com.example.mentos.Model;

public class Mentoring {

    private String title;
    private String start, end;
    private String username;
    private String metoring;
    private String contents;
    private String url;

    public Mentoring(String title, String start, String end, String username, String metoring, String contents, String url) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.username = username;
        this.metoring = metoring;
        this.contents = contents;
        this.url = url;
    }

    public Mentoring() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMetoring() {
        return metoring;
    }

    public void setMetoring(String metoring) {
        this.metoring = metoring;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
