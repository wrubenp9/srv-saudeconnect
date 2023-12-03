package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.GoalEntity;
import com.br.srv.saudeconnect.domain.entity.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GoalMapper {
    Goal entityToDomain(GoalEntity entity);

    List<Goal> entityListToDomainList(List<GoalEntity> entity);
}
