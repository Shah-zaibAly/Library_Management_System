package com.nust.lms.dto;

import jakarta.validation.constraints.Positive;

/**
 * Request body for POST /issue
 * Frontend will send: { "bookId": 101, "memberId": 1 }
 */
public class IssueRequest {
    @Positive
    private int bookId;

    @Positive
    private int memberId;

    public IssueRequest() {}

    public IssueRequest(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
