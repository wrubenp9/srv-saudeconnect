package com.br.srv.saudeconnect.domain.usecase.goal.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.GoalEntity;
import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import com.br.srv.saudeconnect.dataprovider.repository.GoalRepository;
import com.br.srv.saudeconnect.dataprovider.repository.StudentRepository;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.LinkStudentIntoGoalUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkStudentIntoGoalUseCaseImpl implements LinkStudentIntoGoalUseCase {
    private final StudentRepository studentRepository;
    private final GoalRepository goalRepository;

    @Override
    public void execute(String studentId, String goalId) {
        StudentEntity student = studentRepository
                .findByAccount_AccountId(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));

        GoalEntity goal = goalRepository
                .findById(goalId)
                .orElseThrow(() -> new EntityNotFoundException("Goal not found with id: " + goalId));

        goal.getStudents().add(student);
        student.getGoals().add(goal);

        studentRepository.save(student);
    }
}
