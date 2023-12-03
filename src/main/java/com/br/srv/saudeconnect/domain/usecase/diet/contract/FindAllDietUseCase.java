package com.br.srv.saudeconnect.domain.usecase.diet.contract;

import com.br.srv.saudeconnect.domain.entity.Diet;

import java.util.List;

public interface FindAllDietUseCase {
    List<Diet> execute(String professionalId);
}
