package com.br.srv.saudeconnect.domain.usecase.goal.contract;

public interface LinkStudentIntoGoalUseCase {
    void execute(String studentId, String goalId);
}
