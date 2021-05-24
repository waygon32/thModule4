package com.company.service;


import com.company.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICountryService {

    Page<Country> findAll(Pageable pageable);

    Optional<Country> findById(Long id);
}
