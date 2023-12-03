package com.br.srv.saudeconnect.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Meal {
    private String mealId;
    private String mealType;
    private String description;
    private List<String> foods;
    private int calorieCount;
}
