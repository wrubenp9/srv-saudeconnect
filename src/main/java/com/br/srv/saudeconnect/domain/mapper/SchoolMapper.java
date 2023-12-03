package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import com.br.srv.saudeconnect.domain.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchoolMapper {
    //    @Mapping(target = "schoolId", source = "account.accountId")
    School entityToDomain(SchoolEntity entity);

    List<School> entityListToDomainList(List<SchoolEntity> entity);
}
