package com.mmelo.provider.domain;

import com.mmelo.provider.enumerators.DemandStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demand")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_demand")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DemandStatus status;

    @OneToMany(mappedBy = "demand")
    private List<DemandItem> demandItems;
}

