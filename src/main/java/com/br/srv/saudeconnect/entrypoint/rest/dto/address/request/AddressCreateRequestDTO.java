package com.br.srv.saudeconnect.entrypoint.rest.dto.address.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressCreateRequestDTO {
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
