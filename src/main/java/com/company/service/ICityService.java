package com.company.service;

import com.company.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICityService {

    Page<City> findAll(Pageable pageable);

    Optional<City> findById(Long id);

    void save(City city);

    void delete(Long id);
}
