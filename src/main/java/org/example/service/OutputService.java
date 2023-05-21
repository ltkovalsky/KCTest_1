package org.example.service;

import org.example.model.Country;
import org.example.model.Number;

import java.util.List;
import java.util.Map;

public interface OutputService {
    void print(Map<Country, List<Number>> result);
}
