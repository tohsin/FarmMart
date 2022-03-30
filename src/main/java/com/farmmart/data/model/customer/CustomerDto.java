package com.farmmart.data.model.customer;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.staticdata.AgeRange;
import com.farmmart.data.model.staticdata.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @JsonIgnore
    private Long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private AgeRange ageRange;

    private AppUser appUser;
}
