package com.br.srv.saudeconnect.domain.usecase.student.contract;

import com.br.srv.saudeconnect.domain.entity.Student;

import java.util.List;

public interface IFindAllStudentUseCase {

    List<Student> execute();
}
