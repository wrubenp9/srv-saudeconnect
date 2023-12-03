package com.br.srv.saudeconnect.entrypoint.rest.dto.account.response;

import com.br.srv.saudeconnect.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDTO {
    private String accountId;
    private String email;
    private RoleEnum role;
}
