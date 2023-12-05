package com.br.srv.saudeconnect.domain.usecase.professional.implementartion;

import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.DeleteProfessionalUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProfessionalUseCaseImpl implements DeleteProfessionalUseCase {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void execute(String accountId) {
        accountRepository.deleteById(accountId);
    }
}
