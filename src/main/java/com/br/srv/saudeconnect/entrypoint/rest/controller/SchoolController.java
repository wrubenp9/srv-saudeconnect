package com.br.srv.saudeconnect.entrypoint.rest.controller;

import com.br.srv.saudeconnect.domain.entity.Goal;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.CreateGoalUseCase;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.FindGoalBySchoolUseCase;
import com.br.srv.saudeconnect.domain.usecase.school.contract.CreateSchoolUseCase;
import com.br.srv.saudeconnect.domain.usecase.school.contract.FindAllSchoolUseCase;
import com.br.srv.saudeconnect.domain.usecase.school.contract.FindSchoolUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.request.CreateGoalRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response.GoalResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.request.SchoolCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.response.SchoolDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.response.SchoolResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestGoalMapper;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestSchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final FindAllSchoolUseCase findAllSchoolUseCase;
    private final FindSchoolUseCase findSchoolUseCase;
    private final CreateSchoolUseCase createSchoolUseCase;
    private final FindGoalBySchoolUseCase findGoalBySchoolUseCase;
    private final CreateGoalUseCase createGoalUseCase;
    private final RestSchoolMapper restSchoolMapper;
    private final RestGoalMapper restGoalMapper;

    @GetMapping
    public List<SchoolResponseDTO> getAllSchool() {
        return restSchoolMapper.domainListToDtoList(findAllSchoolUseCase.execute());
    }

    @GetMapping("/{schoolId}")
    public SchoolDetailResponseDTO getSchool(@PathVariable String schoolId) {
        return restSchoolMapper.domainToDto(findSchoolUseCase.execute(schoolId));
    }

    @PostMapping
    public void postSchool(@RequestBody SchoolCreateRequestDTO request) {
        createSchoolUseCase.execute(request);
    }

    @PostMapping("/{schoolId}/goals")
    public void postGoal(@PathVariable String schoolId, @RequestBody CreateGoalRequestDTO request) {
        createGoalUseCase.execute(schoolId, request);
    }

    @GetMapping("/{schoolId}/goals")
    public List<GoalResponseDTO> getGoalsForSchool(@PathVariable String schoolId) {
        List<Goal> goals = findGoalBySchoolUseCase.execute(schoolId);
        return restGoalMapper.domainListToDtoList(goals);
    }
}
