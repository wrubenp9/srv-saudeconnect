package com.br.srv.saudeconnect.entrypoint.rest.dto.school.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.response.AddressResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.response.ContactResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response.GoalResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({"schoolId", "schoolName", "address", "contact", "account"})
public class SchoolDetailResponseDTO {
    @JsonProperty("fullName")
    private String schoolName;

    private List<GoalResponseDTO> goals;
    private AddressResponseDTO address;
    private ContactResponseDTO contact;
    private AccountResponseDTO account;
}
