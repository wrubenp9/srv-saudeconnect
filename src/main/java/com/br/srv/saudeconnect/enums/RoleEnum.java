package com.br.srv.saudeconnect.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleEnum {
    STUDENTS("students"),
    PROFESSIONALS("professionals"),
    SCHOOLS("schools"),
    ADMIN("admin");

    private final String type;
}
