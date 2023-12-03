package com.br.srv.saudeconnect.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String contactId;
    private String email;
    private String phone;
    private String instagram;
    private String facebook;
}
