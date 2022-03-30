package com.farmmart.data.model.country;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CountryDto {
    @JsonIgnore
    private Long id;
    private String countryName;
}
