package com.mmelo.provider.service;

import com.mmelo.provider.dto.ProviderAddressDTO;
import com.mmelo.provider.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class ProviderService {

    private final ProviderRepository repository;

    public ProviderAddressDTO findAddressProvider(final String state) {
        return ProviderAddressDTO.builder()
                .address(repository.findByState(state).getAddress())
                .build();
    }
}
