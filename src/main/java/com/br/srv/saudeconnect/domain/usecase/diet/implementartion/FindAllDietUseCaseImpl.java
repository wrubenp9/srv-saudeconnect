package com.br.srv.saudeconnect.domain.usecase.diet.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.entity.Diet;
import com.br.srv.saudeconnect.domain.mapper.DietMapper;
import com.br.srv.saudeconnect.domain.usecase.diet.contract.FindAllDietUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllDietUseCaseImpl implements FindAllDietUseCase {
    private final ProfessionalRepository professionalRepository;
    private final DietMapper dietMapper;

    @Override
    public List<Diet> execute(String professionalId) {
        ProfessionalEntity professional = professionalRepository
                .findByAccount_AccountId(professionalId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + professionalId));

        return dietMapper.entityListToDomainList(professional.getDiets());
    }
}
