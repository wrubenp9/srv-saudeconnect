package com.br.srv.saudeconnect.domain.usecase.student.implementartion;

import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.auth.core.service.account.AccountService;
import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.domain.usecase.address.contract.ICreateAddressUseCase;
import com.br.srv.saudeconnect.domain.usecase.contact.contract.ICreateContactUseCase;
import com.br.srv.saudeconnect.domain.usecase.student.contract.ICreateStudentUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.request.StudentCreateRequestDTO;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import com.br.srv.saudeconnect.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStudentUseCaseImpl implements ICreateStudentUseCase {
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final ICreateAddressUseCase createAddressUseCase;
    private final ICreateContactUseCase createContactUseCase;
    private final AccountService accountService;

    @Override
    public void execute(final StudentCreateRequestDTO request) {

        final Boolean accountExist =
                accountRepository.findByEmail(request.getAccount().getEmail()).isEmpty();

        if (Boolean.TRUE.equals(accountExist)) {

            final StudentEntity studentEntity = StudentEntity.builder()
                    .studentId(IdUtil.generate())
                    .fullName(request.getFullName())
                    .dateOfBirth(request.getDateOfBirth())
                    .gender(request.getGender())
                    .gradeLevel(request.getGradeLevel())
                    .guardianName(request.getGuardianName())
                    .guardianContact(request.getGuardianContact())
                    .hasAllergies(request.isHasAllergies())
                    .allergiesDescription(request.getAllergiesDescription())
                    .hasMedicalConditions(request.isHasMedicalConditions())
                    .medicalConditionsDescription(request.getMedicalConditionsDescription())
                    .contact(createContactUseCase.execute(request.getContact()))
                    .address(createAddressUseCase.execute(request.getAddress()))
                    .account(accountService.createUser(request.getAccount()))
                    .build();

            studentRepository.save(studentEntity);
        } else {
            throw new CustomException(ExceptionEnum.ENTITY_NOT_CREATE);
        }
    }
}
