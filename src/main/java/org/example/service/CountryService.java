package org.example.service;

import org.example.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAvailableCountries();  // could be aggregation method for multiple sources
}
