package com.reza.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reza.warehouse.model.Variant;

@Repository 
public interface VariantRepository extends JpaRepository<Variant, Long> {

    boolean existsByNameAndItemId(String name, Long itemId);
}
