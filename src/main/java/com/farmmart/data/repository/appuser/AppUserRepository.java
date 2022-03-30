package com.farmmart.data.repository.appuser;

import com.farmmart.data.model.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long>,AppUserRepositoryCustom {
}
