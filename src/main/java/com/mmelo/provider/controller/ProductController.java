package com.mmelo.provider.controller;

import com.mmelo.provider.dto.ProductDTO;
import com.mmelo.provider.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(ProductController.PRODUCT_ENDPOINT)
public class ProductController {

    public static final String PRODUCT_ENDPOINT = "/product";
    private final ProductService service;

    @GetMapping(path = "/{state}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> findProductsByState(@PathVariable("state") final String state) {
        return ResponseEntity.ok(service.findProductsByState(state));
    }
}
