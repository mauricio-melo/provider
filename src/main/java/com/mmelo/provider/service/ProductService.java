package com.mmelo.provider.service;

import com.mmelo.provider.dto.ProductDTO;
import com.mmelo.provider.exception.ResourceNotFoundException;
import com.mmelo.provider.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public List<ProductDTO> findProductsByState(final String state) {
        return repository.findByState(state).stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO findById(final Long id) {
        return modelMapper.map(this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString())), ProductDTO.class);
    }
}