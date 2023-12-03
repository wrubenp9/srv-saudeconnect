package com.br.srv.saudeconnect.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "goal")
public class GoalEntity {

    @Id
    private String goalId;

    private String goalType;
    private String goalDescription;
    private String startDate;
    private String endDate;
    private String createdAt;
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @ManyToMany(mappedBy = "goals")
    private List<StudentEntity> students;
}
