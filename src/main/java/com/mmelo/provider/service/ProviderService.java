package com.mmelo.provider.service;

import com.mmelo.provider.dto.ProviderAddressDTO;
import com.mmelo.provider.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderAddressDTO findAddressProvider(final String state) {
        return ProviderAddressDTO.builder()
                .address(this.providerRepository.findByState(state).getAddress())
                .build();
    }
}
