package com.farmmart.data.model.localgovernment;

import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.country.CountryDto;
import com.farmmart.data.model.state.StateDto;
import com.farmmart.data.model.state.States;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalGovernmentDto {
    @JsonIgnore
    private Long id;

    private String localGovernmentName;

    private States state;

//    private String countryName;
}
