package com.farmmart.data.model.country;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NewCountry {
    @NotEmpty(message = "Enter Country name")
    private String countryName;
}
