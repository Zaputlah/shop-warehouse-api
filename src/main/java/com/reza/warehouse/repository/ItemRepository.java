package com.reza.warehouse.repository;

import com.reza.warehouse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByName(String name);

}
