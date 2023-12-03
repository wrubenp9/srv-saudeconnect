package com.br.srv.saudeconnect.domain.usecase.student.contract;

import com.br.srv.saudeconnect.entrypoint.rest.dto.student.request.StudentCreateRequestDTO;

public interface ICreateStudentUseCase {

    void execute(StudentCreateRequestDTO request);
}
