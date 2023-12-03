package com.br.srv.saudeconnect.auth.core.entity;

import com.br.srv.saudeconnect.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`account`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String accountId;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private String createdAt;
    private String updatedAt;
}
