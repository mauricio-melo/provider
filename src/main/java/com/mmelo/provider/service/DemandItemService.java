package com.mmelo.provider.service;

import com.mmelo.provider.domain.Demand;
import com.mmelo.provider.domain.DemandItem;
import com.mmelo.provider.domain.Product;
import com.mmelo.provider.dto.DemandDTO;
import com.mmelo.provider.dto.DemandItemDTO;
import com.mmelo.provider.dto.DemandItemRequestDTO;
import com.mmelo.provider.dto.ItemDTO;
import com.mmelo.provider.repository.DemandItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class DemandItemService {

    private final DemandItemRepository repository;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public List<DemandItemDTO> save(final List<DemandItemRequestDTO> itens, final DemandDTO demandDTO) {
        return itens.stream()
                .map(item -> {
                    final DemandItem demandItem = repository.save(DemandItem.builder()
                            .product(modelMapper.map(productService.findById(item.getProductId()), Product.class))
                            .demand(modelMapper.map(demandDTO, Demand.class))
                            .quantity(item.getQuantity())
                            .build());
                    return modelMapper.map(demandItem, DemandItemDTO.class);
                }).collect(Collectors.toList());
    }

    public List<ItemDTO> findByDemandId(final Long demandId) {
        return repository.findByDemand_id(demandId).stream()
                .map(demandItem -> modelMapper.map(demandItem, ItemDTO.class))
                .collect(Collectors.toList());
    }
}