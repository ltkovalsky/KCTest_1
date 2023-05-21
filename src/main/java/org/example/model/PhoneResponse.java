package org.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class PhoneResponse {
    private int response;
    private List<Number> numbers;
}
