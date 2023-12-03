package com.br.srv.saudeconnect.entrypoint.rest.dto.school.request;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.request.ContactCreateRequestDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolCreateRequestDTO {
    private String schoolName;
    private AddressCreateRequestDTO address;
    private ContactCreateRequestDTO contact;
    private AccountCreateRequestDTO account;
}
