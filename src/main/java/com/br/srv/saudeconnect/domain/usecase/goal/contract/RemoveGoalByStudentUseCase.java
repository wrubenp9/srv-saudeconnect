package com.br.srv.saudeconnect.domain.usecase.goal.contract;

import jakarta.transaction.Transactional;

public interface RemoveGoalByStudentUseCase {
    @Transactional
    void execute(String studentId, String goalId);
}
