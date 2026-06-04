package com.spring.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Region;
import com.spring.repository.RegionRepository;

@Service
public class RegionServices {
	@Autowired
    private RegionRepository regionRepository;

    public Region save(Region region) {
    	region.setCreatedAt(LocalDateTime.now());
        return regionRepository.save(region);
    }

    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    public Optional<Region> getById(Long id) {
        return regionRepository.findById(id);
    }

    public Optional<Region> getByName(String name) {
        return regionRepository.findByRegionName(name);
    }

    public List<Region> getActive() {
        return regionRepository.findByIsActiveTrue();
    }

    public void delete(Long id) {
        regionRepository.deleteById(id);
    }
}