package com.spring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.entity.Region;

public interface RegionRepository  extends JpaRepository<Region, Long>{
	 // Find by region name
    Optional<Region> findByRegionName(String regionName);

    // Check if region name already exists
    boolean existsByRegionName(String regionName);

    // Get only active regions
    List<Region> findByIsActiveTrue();

    // Get active/inactive regions
    List<Region> findByIsActive(boolean isActive);
	
}
