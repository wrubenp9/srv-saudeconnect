package com.br.srv.saudeconnect.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity(name = "meal")
public class MealEntity {

    @Id
    private String mealId;

    private String mealType;
    private String description;
    private List<String> foods;

    private int calorieCount;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private DietEntity diet;
}
