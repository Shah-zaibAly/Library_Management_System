package main.java.com.nust.lms.controller;

import com.nust.se.lmsapi.dto.MemberDto;
import com.nust.se.lmsapi.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembersController {
    private final LibraryService libraryService;

    public MembersController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/members")
    public List<MemberDto> getMembers() {
        return libraryService.getAllMembers();
    }

    @PostMapping("/members")
    public MemberDto addMember(@Valid @RequestBody MemberDto dto) {
        return libraryService.addMember(dto);
    }
}

