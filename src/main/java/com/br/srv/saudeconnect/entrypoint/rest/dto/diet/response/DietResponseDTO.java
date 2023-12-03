package com.br.srv.saudeconnect.entrypoint.rest.dto.diet.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DietResponseDTO {
    private String dietId;
    private String nutritionalTargets;
    private String dietStatus;
    private String startDate;
    private String endDate;
    private List<DietMealResponseDTO> foodsOrMeals;
}
