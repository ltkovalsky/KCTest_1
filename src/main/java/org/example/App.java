package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Country;
import org.example.model.Number;
import org.example.service.CountryService;
import org.example.service.NumberService;
import org.example.service.OutputService;
import org.example.service.OutputServiceConsoleImpl;
import org.example.service.http.CountryServiceHttpImpl;
import org.example.service.http.NumberServiceHttpImpl;

import java.net.http.HttpClient;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        ObjectMapper om = new ObjectMapper();

        CountryService cs = new CountryServiceHttpImpl(httpClient, om);
        NumberService ns = new NumberServiceHttpImpl(httpClient, om);

        ConcurrentMap<Country, List<Number>> result = new ConcurrentHashMap<>();

        cs.getAvailableCountries().parallelStream() // for current simple solution we can use default fork-join pool.
                .forEach(country -> result.put(country, ns.getNumbersByCountry(country)));

        OutputService outputService = new OutputServiceConsoleImpl();   // make ...FileImpl for csv output
        outputService.print(result);
    }
}
