package com.farmmart.data.model.address;

import com.farmmart.data.model.localgovernment.LocalGovernment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAddress {

    private String streetNumber;

    private String streetName;

    private String city;

    private String postZipCode;

    private LocalGovernment localGovernment;
}
