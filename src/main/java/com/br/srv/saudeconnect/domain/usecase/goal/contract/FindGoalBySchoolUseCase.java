package com.br.srv.saudeconnect.domain.usecase.goal.contract;

import com.br.srv.saudeconnect.domain.entity.Goal;

import java.util.List;

public interface FindGoalBySchoolUseCase {
    List<Goal> execute(String accountId);
}
