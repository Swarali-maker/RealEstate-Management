package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Region;
import com.spring.services.RegionServices;

@RestController
@RequestMapping("/regions")
public class RegionController {
	@Autowired
    private RegionServices regionService;

    @PostMapping
    public Region create(@RequestBody Region region) {
        return regionService.save(region);
    }

    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Region> getById(@PathVariable Long id) {
        return regionService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Region> getByName(@PathVariable String name) {
        return regionService.getByName(name);
    }

    @GetMapping("/active")
    public List<Region> getActive() {
        return regionService.getActive();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }
}
