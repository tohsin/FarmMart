package com.farmmart.data.model.appuser;


import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.staticdata.UserType;
import com.farmmart.data.model.userrole.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Collection;

@Data
public class AppUserDto {

    @JsonIgnore
    private Long id;

    private UserType userType;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Collection<UserRole> userRoles;

    private Collection<Address> addresses;
}
