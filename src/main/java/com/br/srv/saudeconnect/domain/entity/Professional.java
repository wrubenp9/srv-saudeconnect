package com.br.srv.saudeconnect.domain.entity;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Professional {
    private String professionalId;
    private String fullName;
    private String idNumber;
    private String specialization;
    private GenderEnum gender;
    private List<Diet> diets;
    private Contact contact;
    private Address address;
    private Account account;
}
