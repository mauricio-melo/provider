package com.mmelo.provider.controller;

import com.mmelo.provider.dto.DemandDTO;
import com.mmelo.provider.dto.DemandDetailsDTO;
import com.mmelo.provider.dto.DemandItemRequestDTO;
import com.mmelo.provider.service.DemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(DemandController.DEMAND_ENDPOINT)
public class DemandController {

    public static final String DEMAND_ENDPOINT = "/demand";
    private final DemandService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<DemandDTO> doDemand(@RequestBody final List<DemandItemRequestDTO> itens) {
        final DemandDTO entity = service.doDemand(itens);
        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<DemandDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDemandDetails(id));
    }
}
