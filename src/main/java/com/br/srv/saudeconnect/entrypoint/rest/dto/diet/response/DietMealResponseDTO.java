package com.br.srv.saudeconnect.entrypoint.rest.dto.diet.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DietMealResponseDTO {
    private String mealId;
    private String mealType;
    private String description;
    private List<String> foods;
    private int calorieCount;
}
