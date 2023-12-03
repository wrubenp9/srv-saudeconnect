package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.dataprovider.entity.AddressEntity;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressEntity requestToEntity(AddressCreateRequestDTO request);
}
