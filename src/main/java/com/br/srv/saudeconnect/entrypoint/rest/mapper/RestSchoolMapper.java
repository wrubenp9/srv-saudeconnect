package com.br.srv.saudeconnect.entrypoint.rest.mapper;

import com.br.srv.saudeconnect.domain.entity.School;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.response.SchoolDetailResponseDTO;
import com.br.srv.saudeconnect.entrypoint.rest.dto.school.response.SchoolResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestSchoolMapper {

    SchoolDetailResponseDTO domainToDto(School domain);

    List<SchoolResponseDTO> domainListToDtoList(List<School> domain);
}
