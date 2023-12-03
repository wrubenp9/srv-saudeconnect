package com.br.srv.saudeconnect.domain.usecase.goal.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.GoalEntity;
import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.GoalRepository;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.RemoveGoalByStudentUseCase;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveGoalByStudentUseCaseImpl implements RemoveGoalByStudentUseCase {
    private final StudentRepository studentRepository;
    private final GoalRepository goalRepository;

    @Override
    @Transactional
    public void execute(String studentId, String goalId) {
        StudentEntity student = studentRepository
                .findByAccount_AccountId(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        GoalEntity goal = goalRepository
                .findById(goalId)
                .orElseThrow(() -> new EntityNotFoundException("Goal not found with id: " + goalId));

        student.getGoals().remove(goal);
        studentRepository.save(student);
    }
}
