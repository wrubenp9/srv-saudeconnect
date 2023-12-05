package com.br.srv.saudeconnect.entrypoint.rest.controller;

import com.br.srv.saudeconnect.domain.entity.Goal;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.FindGoalByStudentUseCase;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.LinkStudentIntoGoalUseCase;
import com.br.srv.saudeconnect.domain.usecase.goal.contract.RemoveGoalByStudentUseCase;
import com.br.srv.saudeconnect.domain.usecase.student.contract.DeleteStudentUseCase;
import com.br.srv.saudeconnect.domain.usecase.student.contract.ICreateStudentUseCase;
import com.br.srv.saudeconnect.domain.usecase.student.contract.IFindAllStudentUseCase;
import com.br.srv.saudeconnect.domain.usecase.student.contract.IFindStudentUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response.GoalResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.request.StudentCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.response.StudentDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.student.response.StudentResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestGoalMapper;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestStudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IFindAllStudentUseCase findAllStudentUseCase;
    private final IFindStudentUseCase findStudentUseCase;
    private final ICreateStudentUseCase createStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final FindGoalByStudentUseCase findGoalByStudentUseCase;
    private final LinkStudentIntoGoalUseCase linkStudentIntoGoalUseCase;
    private final RemoveGoalByStudentUseCase removeGoalByStudentUseCase;
    private final RestStudentMapper restStudentMapper;
    private final RestGoalMapper restGoalMapper;

    @GetMapping
    public List<StudentResponseDTO> getAllStudent() {
        return restStudentMapper.domainListToDtoList(findAllStudentUseCase.execute());
    }

    @GetMapping("/{accountId}")
    public StudentDetailResponseDTO getStudent(@PathVariable String accountId) {
        return restStudentMapper.domainToDto(findStudentUseCase.execute(accountId));
    }

    @PostMapping
    public void postStudent(@RequestBody StudentCreateRequestDTO request) {
        createStudentUseCase.execute(request);
    }

    @GetMapping("/{studentId}/goals")
    public List<GoalResponseDTO> getGoalsForStudent(@PathVariable String studentId) {
        List<Goal> goals = findGoalByStudentUseCase.execute(studentId);
        return restGoalMapper.domainListToDtoList(goals);
    }

    @PutMapping("/{studentId}/goals/{goalId}")
    public void linkStudentToGoal(@PathVariable String studentId, @PathVariable String goalId) {
        linkStudentIntoGoalUseCase.execute(studentId, goalId);
    }

    @DeleteMapping("/{studentId}/goals/{goalId}")
    public void unlinkStudentFromGoal(@PathVariable String studentId, @PathVariable String goalId) {
        removeGoalByStudentUseCase.execute(studentId, goalId);
    }

    @DeleteMapping("/{accountId}")
    public void deleteProfessional(@PathVariable String accountId) {
        deleteStudentUseCase.execute(accountId);
    }
}
