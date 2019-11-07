package com.mmelo.provider.repository;

import com.mmelo.provider.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByState(final String state);
}
