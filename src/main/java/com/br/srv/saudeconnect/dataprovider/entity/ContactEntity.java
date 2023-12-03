package com.br.srv.saudeconnect.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "contact")
public class ContactEntity {

    @Id
    private String contactId;

    private String email;
    private String phone;
    private String instagram;
    private String facebook;
}
