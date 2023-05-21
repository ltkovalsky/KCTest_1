package org.example.service;

import org.example.model.Country;
import org.example.model.Number;

import java.util.List;

public interface NumberService {
    List<Number> getNumbersByCountry(Country country);  // replace class Number for another if new phone source added
}
