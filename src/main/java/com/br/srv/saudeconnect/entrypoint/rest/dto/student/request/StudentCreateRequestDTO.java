package com.br.srv.saudeconnect.entrypoint.rest.dto.student.request;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.request.ContactCreateRequestDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCreateRequestDTO {
    private String fullName;
    private String dateOfBirth;
    private GenderEnum gender;
    private String gradeLevel;
    private String guardianName;
    private String guardianContact;
    private boolean hasAllergies;
    private String allergiesDescription;
    private boolean hasMedicalConditions;
    private String medicalConditionsDescription;
    private AddressCreateRequestDTO address;
    private ContactCreateRequestDTO contact;
    private AccountCreateRequestDTO account;
}
