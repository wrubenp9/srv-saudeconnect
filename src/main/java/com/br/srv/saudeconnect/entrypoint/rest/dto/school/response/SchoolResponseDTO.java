package com.br.srv.saudeconnect.entrypoint.rest.dto.school.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolResponseDTO {
    private String schoolName;
    private AccountResponseDTO account;
}
