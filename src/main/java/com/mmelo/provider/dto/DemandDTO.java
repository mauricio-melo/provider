package com.mmelo.provider.dto;

import com.mmelo.provider.enumerators.DemandStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemandDTO {
    private Long id;
    private DemandStatus status;
}
