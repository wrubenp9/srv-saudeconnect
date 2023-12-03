package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.DietEntity;
import com.br.srv.saudeconnect.domain.entity.Diet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DietMapper {
    Diet entityToDomain(DietEntity entity);

    List<Diet> entityListToDomainList(List<DietEntity> entity);
}
