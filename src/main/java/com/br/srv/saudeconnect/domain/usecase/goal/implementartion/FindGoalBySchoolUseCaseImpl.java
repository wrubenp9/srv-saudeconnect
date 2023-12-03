package com.br.srv.saudeconnect.domain.usecase.goal.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import com.br.srv.saudeconnect.dataprovider.repository.SchoolRepository;
import com.br.srv.saudeconnect.domain.entity.Goal;
import com.br.srv.saudeconnect.domain.mapper.GoalMapper;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.FindGoalBySchoolUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindGoalBySchoolUseCaseImpl implements FindGoalBySchoolUseCase {

    private final SchoolRepository schoolRepository;
    private final GoalMapper goalMapper;

    @Override
    public List<Goal> execute(final String schoolId) {
        SchoolEntity school = schoolRepository
                .findByAccount_AccountId(schoolId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + schoolId));

        return goalMapper.entityListToDomainList(school.getGoals());
    }
}
