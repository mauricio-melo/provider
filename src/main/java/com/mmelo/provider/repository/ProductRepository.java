package com.mmelo.provider.repository;

import com.mmelo.provider.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByState(final String state);
    Set<Product> findByIdIn(final Set<Long> ids);
}
