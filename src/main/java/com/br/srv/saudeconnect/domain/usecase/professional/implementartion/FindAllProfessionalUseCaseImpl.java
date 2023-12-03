package com.br.srv.saudeconnect.domain.usecase.professional.implementartion;

import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.entity.Professional;
import com.br.srv.saudeconnect.domain.mapper.ProfessionalMapper;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.FindAllProfessionalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProfessionalUseCaseImpl implements FindAllProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper professionalMapper;

    @Override
    public List<Professional> execute() {
        return professionalMapper.entityListToDomainList(professionalRepository.findAll());
    }
}
