package com.br.srv.saudeconnect.domain.usecase.student.contract;

import com.br.srv.saudeconnect.domain.entity.Student;

public interface IFindStudentUseCase {
    Student execute(String accountId);
}
