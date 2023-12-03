package com.br.srv.saudeconnect.auth.core.dto;

import com.br.srv.saudeconnect.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    @JsonProperty("id_user")
    private String accountId;

    private String token;

    @JsonProperty("identify_user")
    private RoleEnum role;
}
