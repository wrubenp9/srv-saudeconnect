package com.br.srv.saudeconnect.domain.usecase.professional.implementartion;

import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.auth.core.service.account.AccountService;
import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import com.br.srv.saudeconnect.dataprovider.repository.ProfessionalRepository;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.domain.usecase.address.contract.ICreateAddressUseCase;
import com.br.srv.saudeconnect.domain.usecase.contact.contract.ICreateContactUseCase;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.CreateProfessionalUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.request.ProfessionalCreateRequestDTO;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import com.br.srv.saudeconnect.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProfessionalUseCaseImpl implements CreateProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;
    private final AccountRepository accountRepository;
    private final ICreateAddressUseCase createAddressUseCase;
    private final ICreateContactUseCase createContactUseCase;
    private final AccountService accountService;

    @Override
    public void execute(final ProfessionalCreateRequestDTO request) {

        final Boolean accountExist =
                accountRepository.findByEmail(request.getAccount().getEmail()).isEmpty();

        if (Boolean.TRUE.equals(accountExist)) {

            final ProfessionalEntity professionalEntity = ProfessionalEntity.builder()
                    .professionalId(IdUtil.generate())
                    .fullName(request.getFullName())
                    .idNumber(request.getIdNumber())
                    .specialization(request.getSpecialization())
                    .gender(request.getGender())
                    .contact(createContactUseCase.execute(request.getContact()))
                    .address(createAddressUseCase.execute(request.getAddress()))
                    .account(accountService.createUser(request.getAccount()))
                    .build();

            professionalRepository.save(professionalEntity);
        } else {
            throw new CustomException(ExceptionEnum.ENTITY_NOT_CREATE);
        }
    }
}
