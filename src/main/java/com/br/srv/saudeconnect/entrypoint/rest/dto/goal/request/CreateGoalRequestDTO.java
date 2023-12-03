package com.br.srv.saudeconnect.entrypoint.rest.dto.goal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGoalRequestDTO {
    private String goalType;
    private String goalDescription;
    private String startDate;
    private String endDate;
}
