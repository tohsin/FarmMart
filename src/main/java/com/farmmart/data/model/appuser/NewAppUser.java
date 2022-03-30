package com.farmmart.data.model.appuser;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.staticdata.UserType;
import com.farmmart.data.model.userrole.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAppUser {

    private UserType userType;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Collection<Address> addresses;

    private Collection<UserRole> userRoles;
}
