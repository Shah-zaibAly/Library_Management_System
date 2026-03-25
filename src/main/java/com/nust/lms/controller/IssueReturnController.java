package main.java.com.nust.lms.controller;

import com.nust.se.lmsapi.dto.BookDto;
import com.nust.se.lmsapi.dto.IssueRequest;
import com.nust.se.lmsapi.dto.ReturnRequest;
import com.nust.se.lmsapi.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueReturnController {
    private final LibraryService libraryService;

    public IssueReturnController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/issue")
    public BookDto issue(@Valid @RequestBody IssueRequest req) {
        return libraryService.issueBook(req.getBookId(), req.getMemberId());
    }

    @PostMapping("/return")
    public BookDto returnBook(@Valid @RequestBody ReturnRequest req) {
        return libraryService.returnBook(req.getBookId(), req.getMemberId());
    }
}