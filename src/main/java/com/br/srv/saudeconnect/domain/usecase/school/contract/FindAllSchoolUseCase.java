package com.br.srv.saudeconnect.domain.usecase.school.contract;

import com.br.srv.saudeconnect.domain.entity.School;

import java.util.List;

public interface FindAllSchoolUseCase {

    List<School> execute();
}
