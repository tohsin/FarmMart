package com.farmmart.data.repository.appuser;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.staticdata.Role;
import com.farmmart.data.model.staticdata.UserType;
import com.farmmart.data.model.userrole.UserRole;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AppUserRepositoryCustom {

    @Query("FROM AppUser a WHERE a.username=?1")
    AppUser findByUserName(String username);

    @Query("FROM AppUser a WHERE a.phone=?1")
    AppUser findByPhone(String phone);

    @Query("FROM AppUser a WHERE a.email=?1")
    AppUser findByEmail(String email);

    @Query("FROM AppUser a WHERE a.userType=?1")
    List<AppUser> findByUserType(UserType userType);

}
