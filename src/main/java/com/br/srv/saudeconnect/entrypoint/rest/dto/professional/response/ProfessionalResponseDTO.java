package com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessionalResponseDTO {
    private String fullName;
    private String idNumber;
    private String specialization;
    private GenderEnum gender;
    private AccountResponseDTO account;
}
