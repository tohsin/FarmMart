package com.farmmart.data.model.state;


import com.farmmart.data.model.country.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class StateDto {

    @JsonIgnore
    private Long id;

    private String stateName;

    private Country country;
}
