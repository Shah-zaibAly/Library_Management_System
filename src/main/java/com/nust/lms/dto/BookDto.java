package com.nust.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * DTO = Data Transfer Object.
 * This is the JSON shape we accept/return to the frontend.
 *
 * IMPORTANT: It matches your index.html expectations exactly:
 * { id, title, author, issued, issuedToMemberId }
 */
public class BookDto {
    @Positive
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private boolean issued;

    private Integer issuedToMemberId;

    public BookDto() {}

    public BookDto(int id, String title, String author, boolean issued, Integer issuedToMemberId) {
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
