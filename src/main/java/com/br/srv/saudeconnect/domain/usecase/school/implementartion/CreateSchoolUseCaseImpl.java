package com.br.srv.saudeconnect.domain.usecase.school.implementartion;

import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.auth.core.service.account.AccountService;
import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import com.br.srv.saudeconnect.dataprovider.repository.SchoolRepository;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.domain.usecase.address.contract.ICreateAddressUseCase;
import com.br.srv.saudeconnect.domain.usecase.contact.contract.ICreateContactUseCase;
import com.br.srv.saudeconnect.domain.usecase.school.contract.CreateSchoolUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.request.SchoolCreateRequestDTO;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import com.br.srv.saudeconnect.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSchoolUseCaseImpl implements CreateSchoolUseCase {

    private final SchoolRepository schoolRepository;
    private final AccountRepository accountRepository;
    private final ICreateAddressUseCase createAddressUseCase;
    private final ICreateContactUseCase createContactUseCase;
    private final AccountService accountService;

    @Override
    public void execute(final SchoolCreateRequestDTO request) {

        final Boolean accountExist =
                accountRepository.findByEmail(request.getAccount().getEmail()).isEmpty();

        if (Boolean.TRUE.equals(accountExist)) {

            final SchoolEntity schoolEntity = SchoolEntity.builder()
                    .schoolId(IdUtil.generate())
                    .schoolName(request.getSchoolName())
                    .contact(createContactUseCase.execute(request.getContact()))
                    .address(createAddressUseCase.execute(request.getAddress()))
                    .account(accountService.createUser(request.getAccount()))
                    .build();

            schoolRepository.save(schoolEntity);
        } else {
            throw new CustomException(ExceptionEnum.ENTITY_NOT_CREATE);
        }
    }
}
