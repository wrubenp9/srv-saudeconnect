package com.br.srv.saudeconnect.domain.usecase.goal.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.GoalEntity;
import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import com.br.srv.saudeconnect.dataprovider.repository.GoalRepository;
import com.br.srv.saudeconnect.dataprovider.repository.SchoolRepository;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.CreateGoalUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.request.CreateGoalRequestDTO;
import com.br.srv.saudeconnect.util.DateUtil;
import com.br.srv.saudeconnect.util.IdUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateGoalUseCaseImpl implements CreateGoalUseCase {

    private final GoalRepository goalRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public void execute(String schoolId, CreateGoalRequestDTO request) {
        SchoolEntity school = schoolRepository
                .findByAccount_AccountId(schoolId)
                .orElseThrow(() -> new EntityNotFoundException("School not found with id: " + schoolId));

        GoalEntity goalEntity = GoalEntity.builder()
                .goalId(IdUtil.generate())
                .goalType(request.getGoalType())
                .goalDescription(request.getGoalDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .createdAt(DateUtil.formatDate(LocalDateTime.now()))
                .updatedAt(DateUtil.formatDate(LocalDateTime.now()))
                .build();

        goalEntity.setSchool(school);

        goalRepository.save(goalEntity);
    }
}
