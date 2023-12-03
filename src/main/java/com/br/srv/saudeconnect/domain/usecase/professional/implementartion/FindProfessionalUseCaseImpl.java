package com.br.srv.saudeconnect.domain.usecase.professional.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.entity.Professional;
import com.br.srv.saudeconnect.domain.mapper.ProfessionalMapper;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.FindProfessionalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FindProfessionalUseCaseImpl implements FindProfessionalUseCase {
    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper professionalMapper;

    @Override
    public Professional execute(final String accountId) {
        final ProfessionalEntity professional = professionalRepository
                .findByAccount_AccountId(accountId)
                .orElseThrow(() -> new NotFoundException("Professional not found"));

        return professionalMapper.entityToDomain(professional);
    }
}
