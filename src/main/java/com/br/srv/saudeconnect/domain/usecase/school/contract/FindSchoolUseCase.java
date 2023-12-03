package com.br.srv.saudeconnect.domain.usecase.school.contract;

import com.br.srv.saudeconnect.domain.entity.School;

public interface FindSchoolUseCase {

    School execute(String schoolId);
}
