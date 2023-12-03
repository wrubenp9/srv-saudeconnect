package com.br.srv.saudeconnect.domain.usecase.contact.contract;

import com.br.srv.saudeconnect.dataprovider.entity.ContactEntity;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.request.ContactCreateRequestDTO;

public interface ICreateContactUseCase {
    ContactEntity execute(ContactCreateRequestDTO request);
}
