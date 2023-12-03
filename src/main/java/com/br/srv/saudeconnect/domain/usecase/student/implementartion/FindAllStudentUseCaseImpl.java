package com.br.srv.saudeconnect.domain.usecase.student.implementartion;

import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.entity.Student;
import com.br.srv.saudeconnect.domain.mapper.StudentMapper;
import com.br.srv.saudeconnect.domain.usecase.student.contract.IFindAllStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllStudentUseCaseImpl implements IFindAllStudentUseCase {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<Student> execute() {
        return studentMapper.entityListToDomainList(studentRepository.findAll());
    }
}
