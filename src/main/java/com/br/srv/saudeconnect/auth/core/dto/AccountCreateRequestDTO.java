package com.br.srv.saudeconnect.auth.core.dto;

import com.br.srv.saudeconnect.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateRequestDTO {

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String password;

    @NotNull private RoleEnum role;
}
