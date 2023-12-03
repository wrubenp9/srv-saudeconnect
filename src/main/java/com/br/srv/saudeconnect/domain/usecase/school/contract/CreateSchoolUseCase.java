package com.br.srv.saudeconnect.domain.usecase.school.contract;

import com.br.srv.saudeconnect.entrypoint.rest.dto.school.request.SchoolCreateRequestDTO;

public interface CreateSchoolUseCase {
    void execute(SchoolCreateRequestDTO request);
}
