package com.mmelo.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemandItemDTO {
    private Long id;
    private Integer quantity;
    private ProductDTO product;
    private DemandDTO demand;
}
