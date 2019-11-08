package com.mmelo.provider.repository;

import com.mmelo.provider.domain.DemandItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandItemRepository extends JpaRepository<DemandItem, Long> {
    List<DemandItem> findByDemand_id(final Long demandId);
}
