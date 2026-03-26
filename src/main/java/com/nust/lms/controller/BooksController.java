package main.java.com.nust.lms.controller;

import com.nust.lms.dto.BookDto;
import com.nust.lms.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {
    private final LibraryService libraryService;

    public BooksController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping("/books")
    public BookDto addBook(@Valid @RequestBody BookDto dto) {
        return libraryService.addBook(dto);
    }
}