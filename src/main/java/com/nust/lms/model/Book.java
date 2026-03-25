
/**
 * Book class demonstrates ENCAPSULATION and INTERFACE IMPLEMENTATION.
 * It implements Borrowable, which is a form of POLYMORPHISM:
 * library code can treat all Borrowable items through the same interface.
 */
public class Book implements Borrowable {
    private final int id;
    private final String title;
    private final String author;
    private boolean issued;
    private Integer issuedToMemberId; // null means not issued.

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedToMemberId = null;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public Integer getIssuedToMemberId() {
        return issuedToMemberId;
    }

    @Override
    public boolean issueTo(Member member) {
        if (issued || member == null) {
            return false;
        }
        issued = true;
        issuedToMemberId = member.getId();
        return true;
    }

    @Override
    public boolean returnFrom(Member member) {
        if (!issued || member == null || issuedToMemberId == null) {
            return false;
        }
        if (!issuedToMemberId.equals(member.getId())) {
            return false;
        }
        issued = false;
        issuedToMemberId = null;
        return true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', issued=" + issued + "}";
    }
}
