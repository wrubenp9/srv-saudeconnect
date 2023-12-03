package com.br.srv.saudeconnect.entrypoint.rest.dto.professional.request;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.request.ContactCreateRequestDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessionalCreateRequestDTO {
    private String fullName;
    private String idNumber;
    private String specialization;
    private GenderEnum gender;
    private ContactCreateRequestDTO contact;
    private AddressCreateRequestDTO address;
    private AccountCreateRequestDTO account;
}
