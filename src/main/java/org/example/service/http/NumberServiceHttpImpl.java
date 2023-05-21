package org.example.service.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Country;
import org.example.model.Number;
import org.example.model.PhoneResponse;
import org.example.service.NumberService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NumberServiceHttpImpl extends AbstractHttpService implements NumberService {

    public NumberServiceHttpImpl(HttpClient httpClient, ObjectMapper om) {
        super(httpClient, om);
    }

    @Override
    public List<Number> getNumbersByCountry(Country country) {
        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(new URI("https://onlinesim.ru/api/getFreePhoneList?country=" + country.getCountry()))  // move url to app.prop in spring impl
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            PhoneResponse pRes = om.readValue(response.body(), PhoneResponse.class);
            return pRes.getNumbers();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
