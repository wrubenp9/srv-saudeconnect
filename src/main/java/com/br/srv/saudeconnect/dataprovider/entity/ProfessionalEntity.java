package com.br.srv.saudeconnect.dataprovider.entity;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.enums.GenderEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "professional")
public class ProfessionalEntity {
    @Id
    private String professionalId;

    private String fullName;
    private String idNumber;
    private String specialization;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    private List<DietEntity> diets;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
