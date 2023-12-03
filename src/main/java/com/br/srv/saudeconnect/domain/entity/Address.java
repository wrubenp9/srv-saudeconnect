package com.br.srv.saudeconnect.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String addressId;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
