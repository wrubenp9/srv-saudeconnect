package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import com.br.srv.saudeconnect.domain.entity.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfessionalMapper {
    Professional entityToDomain(ProfessionalEntity entity);

    List<Professional> entityListToDomainList(List<ProfessionalEntity> entity);
}
