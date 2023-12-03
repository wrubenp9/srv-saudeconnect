package com.br.srv.saudeconnect.domain.mapper;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.auth.core.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    Account requestToEntity(AccountCreateRequestDTO request);
}
