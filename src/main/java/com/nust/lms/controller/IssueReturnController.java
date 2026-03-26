package com.nust.lms.controller;

import com.nust.lms.dto.BookDto;
import com.nust.lms.dto.IssueRequest;
import com.nust.lms.dto.ReturnRequest;
import com.nust.lms.service.LibraryService;
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