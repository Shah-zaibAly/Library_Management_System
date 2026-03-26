package com.nust.lms.domain;

/**
 * "Entity" (in-memory) version of your Book.
 * We store exactly the same fields your frontend expects.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private Integer issuedToMemberId; // null => not issued

    public Book() {}

    public Book(int id, String title, String author, boolean issued, Integer issuedToMemberId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
        this.issuedToMemberId = issuedToMemberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Integer getIssuedToMemberId() {
        return issuedToMemberId;
    }

    public void setIssuedToMemberId(Integer issuedToMemberId) {
        this.issuedToMemberId = issuedToMemberId;
    }
}
