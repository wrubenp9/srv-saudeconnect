package com.br.srv.saudeconnect.dataprovider.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Entity(name = "diet")
public class DietEntity {
    @Id
    private String dietId;

    private String nutritionalTargets;
    private String dietStatus; // Status da dieta (ativa, inativa, concluída, etc.)
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<MealEntity> foodsOrMeals;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private ProfessionalEntity professional;
}
