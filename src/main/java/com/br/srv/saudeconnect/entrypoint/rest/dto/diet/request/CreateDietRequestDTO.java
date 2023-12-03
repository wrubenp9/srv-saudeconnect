package com.br.srv.saudeconnect.entrypoint.rest.dto.diet.request;

import com.br.srv.saudeconnect.domain.entity.Meal;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateDietRequestDTO {
    private String nutritionalTargets;
    private String dietStatus;
    private String startDate;
    private String endDate;
    private List<Meal> foodsOrMeals;
    private String studentId;
    private String professionalId;
}
