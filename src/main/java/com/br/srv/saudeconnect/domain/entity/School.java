package com.br.srv.saudeconnect.domain.entity;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class School {
    private String schoolId;
    private String schoolName;
    private List<Goal> goals;
    private Address address;
    private Contact contact;
    private Account account;
}
