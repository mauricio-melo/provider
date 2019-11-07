package com.mmelo.provider.controller;

import com.mmelo.provider.dto.ProviderAddressDTO;
import com.mmelo.provider.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(ProviderController.PROVIDER_ENDPOINT)
public class ProviderController {

    public static final String PROVIDER_ENDPOINT = "/provider";
    private final ProviderService service;

    @GetMapping(path = "/info/{state}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProviderAddressDTO> findAddressProvider(@Valid @PathVariable final String state) {
        return ResponseEntity.ok(service.findAddressProvider(state));
    }
}