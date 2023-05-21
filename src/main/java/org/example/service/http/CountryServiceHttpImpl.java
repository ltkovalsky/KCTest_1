package org.example.service.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Country;
import org.example.model.CountryResponse;
import org.example.service.CountryService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CountryServiceHttpImpl extends AbstractHttpService implements CountryService {

    public CountryServiceHttpImpl(HttpClient httpClient, ObjectMapper om) {   // replace to bean injection for spring impl
        super(httpClient, om);
    }

    @Override
    public List<Country> getAvailableCountries() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://onlinesim.ru/api/getFreeCountryList"))    // move to app.prop in spring impl
                    .GET()
                    .build();

            HttpResponse<String> res = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            CountryResponse countryResponse = om.readValue(res.body(), CountryResponse.class);

            return countryResponse.getCountries();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
