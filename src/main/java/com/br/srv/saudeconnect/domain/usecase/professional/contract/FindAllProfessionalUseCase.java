package com.br.srv.saudeconnect.domain.usecase.professional.contract;

import com.br.srv.saudeconnect.domain.entity.Professional;

import java.util.List;

public interface FindAllProfessionalUseCase {
    List<Professional> execute();
}
