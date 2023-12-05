package com.br.srv.saudeconnect.domain.usecase.student.implementartion;

import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.usecase.student.contract.DeleteStudentUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStudentUseCaseImpl implements DeleteStudentUseCase {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void execute(String accountId) {
        studentRepository.deleteByAccount_AccountId(accountId);
    }
}
