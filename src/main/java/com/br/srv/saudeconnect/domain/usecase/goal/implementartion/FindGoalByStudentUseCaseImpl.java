package com.br.srv.saudeconnect.domain.usecase.goal.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.entity.Goal;
import com.br.srv.saudeconnect.domain.mapper.GoalMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindGoalByStudentUseCaseImpl
        implements com.br.srv.saudeconnect.domain.usecase.goal.contract.FindGoalByStudentUseCase {
    private final StudentRepository studentRepository;
    private final GoalMapper goalMapper;

    @Override
    public List<Goal> execute(String studentId) {
        StudentEntity student = studentRepository
                .findByAccount_AccountId(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + studentId));

        return goalMapper.entityListToDomainList(student.getGoals());
    }
}
