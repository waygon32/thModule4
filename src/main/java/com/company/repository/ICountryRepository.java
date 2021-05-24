package com.company.repository;

import com.company.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICountryRepository extends PagingAndSortingRepository<Country,Long> {
}
