package com.company.fomatter;


import com.company.model.Country;
import com.company.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;


import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CountryFormatter implements Formatter<Country> {
    private ICountryService countryService;

//    @Autowired
    public CountryFormatter(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        Optional<Country> country = countryService.findById(Long.parseLong(text));
        return country.orElse(null);
    }

    @Override
    public String print(Country object, Locale locale) {
        return null;
    }
}
