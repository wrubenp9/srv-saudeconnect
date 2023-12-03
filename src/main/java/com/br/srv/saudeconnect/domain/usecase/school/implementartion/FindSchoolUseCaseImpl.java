package com.br.srv.saudeconnect.domain.usecase.school.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import com.br.srv.saudeconnect.dataprovider.repository.SchoolRepository;
import com.br.srv.saudeconnect.domain.entity.School;
import com.br.srv.saudeconnect.domain.mapper.SchoolMapper;
import com.br.srv.saudeconnect.domain.usecase.school.contract.FindSchoolUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FindSchoolUseCaseImpl implements FindSchoolUseCase {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public School execute(final String schoolId) {

        SchoolEntity school = schoolRepository
                .findByAccount_AccountId(schoolId)
                .orElseThrow(() -> new NotFoundException("School not found"));

        return schoolMapper.entityToDomain(school);
    }
}
