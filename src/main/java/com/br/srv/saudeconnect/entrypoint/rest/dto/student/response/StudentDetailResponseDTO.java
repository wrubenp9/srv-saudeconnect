package com.br.srv.saudeconnect.entrypoint.rest.dto.student.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.response.AddressResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.response.ContactResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response.GoalResponseDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDetailResponseDTO {
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
    private AddressResponseDTO address;
    private ContactResponseDTO contact;
    private AccountResponseDTO account;
    private List<GoalResponseDTO> goals;
}
