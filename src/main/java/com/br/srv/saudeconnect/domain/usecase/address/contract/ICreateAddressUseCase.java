package com.br.srv.saudeconnect.domain.usecase.address.contract;

import com.br.srv.saudeconnect.dataprovider.entity.AddressEntity;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;

public interface ICreateAddressUseCase {
    AddressEntity execute(AddressCreateRequestDTO request);
}
