package com.br.srv.saudeconnect.domain.usecase.student.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.entity.Student;
import com.br.srv.saudeconnect.domain.mapper.StudentMapper;
import com.br.srv.saudeconnect.domain.usecase.student.contract.IFindStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FindStudentUseCaseImpl implements IFindStudentUseCase {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Student execute(final String accountId) {

        StudentEntity school = studentRepository
                .findByAccount_AccountId(accountId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        return studentMapper.entityToDomain(school);
    }
}
