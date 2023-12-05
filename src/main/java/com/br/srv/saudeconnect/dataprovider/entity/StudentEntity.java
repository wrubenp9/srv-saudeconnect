package com.br.srv.saudeconnect.dataprovider.entity;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.enums.GenderEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "Student")
public class StudentEntity {
    @Id
    private String studentId;

    private String fullName;
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender; // Sexo do estudante

    private String gradeLevel; // Nível de série do aluno
    private String guardianName; // Nome do responsável pelo aluno
    private String guardianContact; // Informações de contato do responsável
    private boolean hasAllergies; // Indica se o aluno tem alergias alimentares
    private String allergiesDescription; // Descrição das alergias, se aplicável
    private boolean hasMedicalConditions; // Indica se o aluno tem condições médicas
    private String medicalConditionsDescription; // Descrição das condições médicas, se aplicável

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_goal",
            joinColumns = {@JoinColumn(name = "goal_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<GoalEntity> goals;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;
}
