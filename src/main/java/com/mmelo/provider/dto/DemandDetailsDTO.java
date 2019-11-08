package com.mmelo.provider.dto;

import com.mmelo.provider.enumerators.DemandStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemandDetailsDTO {
    private Long id;
    private DemandStatus status;
    private List<ItemDTO> itens;
}