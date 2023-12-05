package com.br.srv.saudeconnect.domain.entity;

import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Goal {
    private String goalId;
    private String goalType;
    private String goalDescription;
    private String startDate;
    private String endDate;
    private String createdAt;
    private String updatedAt;
    private SchoolEntity school;
}
