package org.example.service;

import org.example.model.Country;
import org.example.model.Number;

import java.util.List;
import java.util.Map;

public class OutputServiceConsoleImpl implements OutputService {
    @Override
    public void print(Map<Country, List<Number>> result) {
        result.forEach((key, value) -> {
            System.out.println("---");
            value.forEach(num ->
                    System.out.printf("Country: %s, Number: %s\n", key.getCountryText(), num.getFullNumber()));
        });
    }
}
