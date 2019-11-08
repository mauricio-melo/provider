package com.mmelo.provider.repository;

import com.mmelo.provider.domain.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Long> {
}
