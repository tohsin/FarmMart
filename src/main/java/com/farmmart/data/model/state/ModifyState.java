package com.farmmart.data.model.state;

import com.farmmart.data.model.country.Country;
import lombok.Data;

@Data
public class ModifyState {
    private Long id;

    private String stateName;

    private Country country;
}
