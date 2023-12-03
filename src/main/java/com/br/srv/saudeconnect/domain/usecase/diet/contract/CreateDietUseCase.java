package com.br.srv.saudeconnect.domain.usecase.diet.contract;

import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.request.CreateDietRequestDTO;

public interface CreateDietUseCase {
    void execute(String professionalId, String studentId, CreateDietRequestDTO request);
}
