package com.br.srv.saudeconnect.domain.usecase.professional.contract;

import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.request.ProfessionalCreateRequestDTO;

public interface CreateProfessionalUseCase {
    void execute(ProfessionalCreateRequestDTO request);
}
