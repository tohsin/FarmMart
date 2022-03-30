package com.farmmart.data.repository.userrole;

import com.farmmart.data.model.userrole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long>,UserRoleRepositoryCustom {
}
