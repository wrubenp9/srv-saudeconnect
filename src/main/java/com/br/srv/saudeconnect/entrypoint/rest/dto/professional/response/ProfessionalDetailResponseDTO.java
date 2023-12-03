package com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.response.AddressResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.response.ContactResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.response.DietResponseDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProfessionalDetailResponseDTO {
    private String fullName;
    private String idNumber;
    private String specialization;
    private GenderEnum gender;
    private List<DietResponseDTO> diets;
    private AddressResponseDTO address;
    private ContactResponseDTO contact;
    private AccountResponseDTO account;
}
