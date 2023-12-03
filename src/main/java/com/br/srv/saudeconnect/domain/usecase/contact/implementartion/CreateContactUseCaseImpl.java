package com.br.srv.saudeconnect.domain.usecase.contact.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.ContactEntity;
import com.br.srv.saudeconnect.dataprovider.repository.ContactRepository;
import com.br.srv.saudeconnect.domain.usecase.contact.contract.ICreateContactUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.contact.request.ContactCreateRequestDTO;
import com.br.srv.saudeconnect.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateContactUseCaseImpl implements ICreateContactUseCase {
    private final ContactRepository contactRepository;

    @Override
    public ContactEntity execute(final ContactCreateRequestDTO request) {

        final ContactEntity contact = ContactEntity.builder()
                .contactId(IdUtil.generate())
                .email(request.getEmail())
                .phone(request.getPhone())
                .instagram(request.getInstagram())
                .facebook(request.getFacebook())
                .build();

        return contactRepository.save(contact);
    }
}
