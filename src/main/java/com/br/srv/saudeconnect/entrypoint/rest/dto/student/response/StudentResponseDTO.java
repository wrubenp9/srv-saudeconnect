package com.br.srv.saudeconnect.entrypoint.rest.dto.student.response;

import com.br.srv.saudeconnect.entrypoint.rest.dto.account.response.AccountResponseDTO;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDTO {
    private String fullName;
    private String dateOfBirth;
    private GenderEnum gender;
    private String gradeLevel;
    private String guardianName;
    private String guardianContact;
    private AccountResponseDTO account;
}
