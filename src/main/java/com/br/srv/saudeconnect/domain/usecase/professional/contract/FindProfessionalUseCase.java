package com.br.srv.saudeconnect.domain.usecase.professional.contract;

import com.br.srv.saudeconnect.domain.entity.Professional;

public interface FindProfessionalUseCase {
    Professional execute(String accountId);
}
