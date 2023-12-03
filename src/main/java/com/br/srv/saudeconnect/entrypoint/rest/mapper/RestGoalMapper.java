package com.br.srv.saudeconnect.entrypoint.rest.mapper;

import com.br.srv.saudeconnect.domain.entity.Goal;
import com.br.srv.saudeconnect.entrypoint.rest.dto.goal.response.GoalResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestGoalMapper {
    GoalResponseDTO domainToDto(Goal domain);

    List<GoalResponseDTO> domainListToDtoList(List<Goal> domain);
}
