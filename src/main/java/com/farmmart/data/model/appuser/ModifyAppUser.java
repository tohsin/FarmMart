package com.farmmart.data.model.appuser;

import com.farmmart.data.model.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyAppUser {

    private Long id;

    private String password;

    private String phone;

    private Collection<Address> addresses;
}
