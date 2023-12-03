package com.br.srv.saudeconnect.entrypoint.rest.mapper;

import com.br.srv.saudeconnect.domain.entity.Professional;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response.ProfessionalDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.professional.response.ProfessionalResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestProfessionalMapper {

    ProfessionalDetailResponseDTO domainToDto(Professional domain);

    List<ProfessionalResponseDTO> domainListToDtoList(List<Professional> domain);
}
