package com.nust.lms.model;

/**
 * Updated Book class to support Spring Boot Service logic.
 * Maintains ENCAPSULATION and POLYMORPHISM via Borrowable.
 */
public class Book implements Borrowable {
    private int id; // Removed 'final' so the service can manage it
    private String title;
    private String author;
    private boolean issued;
    private Integer issuedToMemberId;

    // REQUIRED: 5-argument constructor for LibraryService logic
    public Book(int id, String title, String author, boolean issued, Integer issuedToMemberId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
        this.issuedToMemberId = issuedToMemberId;
    }

    // Keep your original 3-argument constructor for simpler use cases
    public Book(int id, String title, String author) {
        this(id, title, author, false, null);
    }

    // --- GETTERS ---
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }
    public Integer getIssuedToMemberId() { return issuedToMemberId; }

    // --- SETTERS (Fixed the 'Cannot resolve method' errors) ---
    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public void setIssuedToMemberId(Integer issuedToMemberId) {
        this.issuedToMemberId = issuedToMemberId;
    }

    @Override
    public boolean issueTo(Member member) {
        if (issued || member == null) return false;
        setIssued(true);
        setIssuedToMemberId(member.getId());
        return true;
    }

    @Override
    public boolean returnFrom(Member member) {
        if (!issued || member == null || !issuedToMemberId.equals(member.getId())) return false;
        setIssued(false);
        setIssuedToMemberId(null);
        return true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', issued=" + issued + "}";
    }
}
