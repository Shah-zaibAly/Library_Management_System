package com.nust.lms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * Matches your frontend expectations exactly:
 * { id, name, email }
 */
public class MemberDto {
    @Positive
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    public MemberDto() {}

    public MemberDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
