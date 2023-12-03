package com.br.srv.saudeconnect.domain.usecase.goal.contract;

import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.request.CreateGoalRequestDTO;

public interface CreateGoalUseCase {
    void execute(String schoolId, CreateGoalRequestDTO request);
}
