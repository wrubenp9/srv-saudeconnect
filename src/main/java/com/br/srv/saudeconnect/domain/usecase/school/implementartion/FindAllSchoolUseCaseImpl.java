package com.br.srv.saudeconnect.domain.usecase.school.implementartion;

import com.br.srv.saudeconnect.dataprovider.repository.SchoolRepository;
import com.br.srv.saudeconnect.domain.entity.School;
import com.br.srv.saudeconnect.domain.mapper.SchoolMapper;
import com.br.srv.saudeconnect.domain.usecase.school.contract.FindAllSchoolUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllSchoolUseCaseImpl implements FindAllSchoolUseCase {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public List<School> execute() {
        return schoolMapper.entityListToDomainList(schoolRepository.findAll());
    }
}
