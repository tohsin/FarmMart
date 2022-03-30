package com.farmmart.data.repository.userrole;

import com.farmmart.data.model.userrole.UserRole;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepositoryCustom {
    @Query("FROM UserRole u WHERE u.roleName=?1")
    UserRole findByRoleName(String roleName);
}


