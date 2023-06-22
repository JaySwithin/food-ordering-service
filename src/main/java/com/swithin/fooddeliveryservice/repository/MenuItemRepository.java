package com.swithin.fooddeliveryservice.repository;

import com.swithin.fooddeliveryservice.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    MenuItem findByItemId(Long id);
}
