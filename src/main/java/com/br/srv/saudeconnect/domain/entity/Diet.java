package com.br.srv.saudeconnect.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Diet {
    private String dietId;
    private String nutritionalTargets;
    private String dietStatus;
    private String startDate;
    private String endDate;
    private List<Meal> foodsOrMeals;
}
