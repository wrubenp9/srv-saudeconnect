package com.br.srv.saudeconnect.domain.usecase.professional.implementartion;

import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.DeleteProfessionalUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProfessionalUseCaseImpl implements DeleteProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    @Override
    @Transactional
    public void execute(String accountId) {
        professionalRepository.deleteByAccount_AccountId(accountId);
    }
}
