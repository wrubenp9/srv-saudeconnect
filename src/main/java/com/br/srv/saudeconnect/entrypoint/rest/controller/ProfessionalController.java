package com.br.srv.saudeconnect.entrypoint.rest.controller;

import com.br.srv.saudeconnect.domain.usecase.diet.contract.CreateDietUseCase;
import com.br.srv.saudeconnect.domain.usecase.diet.contract.FindAllDietUseCase;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.CreateProfessionalUseCase;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.DeleteProfessionalUseCase;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.FindAllProfessionalUseCase;
import com.br.srv.saudeconnect.domain.usecase.professional.contract.FindProfessionalUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.request.CreateDietRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.response.DietResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.request.ProfessionalCreateRequestDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response.ProfessionalDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response.ProfessionalResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestDietMapper;
import com.br.srv.saudeconnect.entrypoint.rest.mapper.RestProfessionalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/professionals")
@RequiredArgsConstructor
public class ProfessionalController {

    private final FindProfessionalUseCase findProfessionalUseCase;
    private final FindAllProfessionalUseCase findAllProfessionalUseCase;
    private final CreateProfessionalUseCase createProfessionalUseCase;
    private final FindAllDietUseCase findAllDietUseCase;
    private final CreateDietUseCase createDietUseCase;
    private final DeleteProfessionalUseCase deleteProfessionalUseCase;
    private final RestProfessionalMapper restProfessionalMapper;
    private final RestDietMapper restDietMapper;

    @GetMapping
    public List<ProfessionalResponseDTO> getAllProfessional() {
        return restProfessionalMapper.domainListToDtoList(findAllProfessionalUseCase.execute());
    }

    @GetMapping("/{accountId}")
    public ProfessionalDetailResponseDTO getProfessional(@PathVariable String accountId) {
        return restProfessionalMapper.domainToDto(findProfessionalUseCase.execute(accountId));
    }

    @PostMapping
    public void postProfessional(@RequestBody ProfessionalCreateRequestDTO request) {
        createProfessionalUseCase.execute(request);
    }

    @PostMapping("/{professionalId}/students/{studentId}/diets")
    public void postDiet(
            @PathVariable String professionalId,
            @PathVariable String studentId,
            @RequestBody CreateDietRequestDTO request) {
        createDietUseCase.execute(professionalId, studentId, request);
    }

    @GetMapping("/{professionalId}/students/{studentId}/diets")
    public List<DietResponseDTO> getAllDiet(@PathVariable String professionalId) {
        return restDietMapper.domainListToDtoList(findAllDietUseCase.execute(professionalId));
    }

    @DeleteMapping("/{accountId}")
    public void deleteProfessional(@PathVariable String accountId) {
        deleteProfessionalUseCase.execute(accountId);
    }
}
