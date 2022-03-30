package com.farmmart.data.model.customer;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.staticdata.AgeRange;
import com.farmmart.data.model.staticdata.Gender;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCustomer {
    private String firstName;

    private String lastName;

    private Gender gender;

    private AgeRange ageRange;

    private AppUser appUser;
}
