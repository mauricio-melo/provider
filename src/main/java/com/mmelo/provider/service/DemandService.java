package com.mmelo.provider.service;

import com.mmelo.provider.domain.Demand;
import com.mmelo.provider.dto.DemandDTO;
import com.mmelo.provider.dto.DemandDetailsDTO;
import com.mmelo.provider.dto.DemandItemRequestDTO;
import com.mmelo.provider.enumerators.DemandStatus;
import com.mmelo.provider.exception.ResourceNotFoundException;
import com.mmelo.provider.repository.DemandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class DemandService {

    private final DemandRepository repository;
    private final DemandItemService demandItemService;
    private final ModelMapper modelMapper;

    @Transactional
    public DemandDTO doDemand(final List<DemandItemRequestDTO> itens) {
        final Demand demand = repository.save(Demand.builder()
                .status(DemandStatus.RECEIVED)
                .build());
        final DemandDTO demandDTO = modelMapper.map(demand, DemandDTO.class);
        demandItemService.save(itens, demandDTO);
        return demandDTO;
    }

    public DemandDTO findById(final Long id) {
        return modelMapper.map(this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString())), DemandDTO.class);
    }

    public DemandDetailsDTO findDemandDetails(final Long id) {
        final DemandDTO demand = findById(id);
        return DemandDetailsDTO.builder()
                .id(demand.getId())
                .status(demand.getStatus())
                .itens(demandItemService.findByDemandId(demand.getId()))
                .build();
    }
}
