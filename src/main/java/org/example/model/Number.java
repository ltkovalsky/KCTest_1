package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.utils.CustomDateTimeDeserializer;

import java.time.LocalDateTime;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Number {
    private String number;
    private int country;
    @JsonProperty("updated_at")
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    @JsonProperty("data_humans")
    private String dataHumans;
    @JsonProperty("full_number")
    private String fullNumber;
    @JsonProperty("country_text")
    private String countryText;
    @JsonProperty("maxdate")
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private LocalDateTime maxDate;
    private String status;

}
