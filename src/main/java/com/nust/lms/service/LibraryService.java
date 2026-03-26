package main.java.com.nust.lms.service;

import com.nust.se.lmsapi.domain.Book;
import com.nust.se.lmsapi.domain.Member;
import com.nust.se.lmsapi.dto.BookDto;
import com.nust.se.lmsapi.dto.MemberDto;
import com.nust.se.lmsapi.exception.BadRequestException;
import com.nust.se.lmsapi.exception.NotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory "business logic" like your console Library class.
 * Uses ArrayList storage as requested (no database).
 */
@Service
public class LibraryService {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();

    @PostConstruct
    public void seedDemoData() {
        // Demo members (same spirit as your console preload)
        members.add(new Member(1, "Aarav", "aarav@example.com"));
        members.add(new Member(2, "Meera", "meera@example.com"));
        members.add(new Member(3, "Ayesha", "ayesha@nust.edu.pk"));

        // Demo books (matching your frontend's demo)
        books.add(new Book(101, "Clean Code", "Robert C. Martin", false, null));
        books.add(new Book(102, "Effective Java", "Joshua Bloch", true, 2));
        books.add(new Book(103, "The Pragmatic Programmer", "Andrew Hunt", false, null));
    }

    public List<BookDto> getAllBooks() {
        return books.stream().map(this::toDto).toList();
    }

    public List<MemberDto> getAllMembers() {
        return members.stream().map(this::toDto).toList();
    }

    public BookDto addBook(BookDto dto) {
        if (findBookById(dto.getId()) != null) {
            throw new BadRequestException("A book with this ID already exists.");
        }
        Book book = new Book(dto.getId(), dto.getTitle(), dto.getAuthor(), false, null);
        books.add(book);
        return toDto(book);
    }

    public MemberDto addMember(MemberDto dto) {
        if (findMemberById(dto.getId()) != null) {
            throw new BadRequestException("A member with this ID already exists.");
        }
        Member member = new Member(dto.getId(), dto.getName(), dto.getEmail());
        members.add(member);
        return toDto(member);
    }

    public BookDto issueBook(int bookId, int memberId) {
        Book book = requireBook(bookId);
        Member member = requireMember(memberId);

        if (book.isIssued()) {
            throw new BadRequestException("This book is already issued.");
        }

        book.setIssued(true);
        book.setIssuedToMemberId(member.getId());
        return toDto(book);
    }

    public BookDto returnBook(int bookId, int memberId) {
        Book book = requireBook(bookId);
        requireMember(memberId); // validates member exists (like console app)

        if (!book.isIssued()) {
            throw new BadRequestException("This book is not currently issued.");
        }
        if (book.getIssuedToMemberId() == null || book.getIssuedToMemberId() != memberId) {
            throw new BadRequestException("Return failed: this book was issued to a different member.");
        }

        book.setIssued(false);
        book.setIssuedToMemberId(null);
        return toDto(book);
    }

    private Book requireBook(int id) {
        Book b = findBookById(id);
        if (b == null) throw new NotFoundException("Book not found.");
        return b;
    }

    private Member requireMember(int id) {
        Member m = findMemberById(id);
        if (m == null) throw new NotFoundException("Member not found.");
        return m;
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    private BookDto toDto(Book b) {
        return new BookDto(b.getId(), b.getTitle(), b.getAuthor(), b.isIssued(), b.getIssuedToMemberId());
    }

    private MemberDto toDto(Member m) {
        return new MemberDto(m.getId(), m.getName(), m.getEmail());
    }
}
