package com.br.srv.saudeconnect.domain.entity;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.enums.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student {
    private String studentId;
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
    private Address address;
    private Contact contact;
    private Account account;
    private List<Goal> students;
}
