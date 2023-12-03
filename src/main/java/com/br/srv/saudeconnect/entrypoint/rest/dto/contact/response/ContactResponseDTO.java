package com.br.srv.saudeconnect.entrypoint.rest.dto.contact.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactResponseDTO {
    private String email;
    private String phone;
    private String instagram;
    private String facebook;
}
