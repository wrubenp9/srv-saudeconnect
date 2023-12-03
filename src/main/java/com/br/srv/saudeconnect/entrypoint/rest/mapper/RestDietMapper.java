package com.br.srv.saudeconnect.entrypoint.rest.mapper;

import com.br.srv.saudeconnect.domain.entity.Diet;
import com.br.srv.saudeconnect.entrypoint.rest.dto.diet.response.DietResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestDietMapper {
    DietResponseDTO domainToDto(Diet domain);

    List<DietResponseDTO> domainListToDtoList(List<Diet> domain);
}
