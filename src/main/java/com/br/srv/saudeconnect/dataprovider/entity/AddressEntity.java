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
@Entity(name = "address")
public class AddressEntity {

    @Id
    private String addressId;

    private String street;
    private String city;
    private String state;
    private String postalCode;
}
