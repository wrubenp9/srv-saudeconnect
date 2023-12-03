package com.br.srv.saudeconnect.domain.usecase.address.implementartion;

import com.br.srv.saudeconnect.dataprovider.entity.AddressEntity;
import com.br.srv.saudeconnect.dataprovider.repository.AddressRepository;
import com.br.srv.saudeconnect.domain.usecase.address.contract.ICreateAddressUseCase;
import com.br.srv.saudeconnect.entrypoint.rest.dto.address.request.AddressCreateRequestDTO;
import com.br.srv.saudeconnect.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAddressUseCaseImpl implements ICreateAddressUseCase {
    private final AddressRepository addressRepository;

    @Override
    public AddressEntity execute(final AddressCreateRequestDTO request) {

        final AddressEntity address = AddressEntity.builder()
                .addressId(IdUtil.generate())
                .street(request.getStreet())
                .city(request.getCity())
                .state(request.getState())
                .postalCode(request.getPostalCode())
                .build();

        return addressRepository.save(address);
    }
}
