package com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalResponseDTO {
    private String goalId;
    private String goalType;
    private String goalDescription;
    private String startDate;
    private String endDate;
    private String createdAt;
    private String updatedAt;
}
