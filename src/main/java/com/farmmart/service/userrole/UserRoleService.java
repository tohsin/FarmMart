package com.farmmart.service.userrole;

import com.farmmart.data.model.staticdata.Role;
import com.farmmart.data.model.userrole.UserRole;
import com.farmmart.data.model.userrole.UserRoleNotFoundException;

import java.util.List;

public interface UserRoleService {
    UserRole saveUserRole(UserRole userRole) throws UserRoleNotFoundException;
    UserRole findUserRoleById(Long id) throws UserRoleNotFoundException;
    UserRole findUserRoleByName(String name) throws UserRoleNotFoundException;
    List<UserRole> findAllUserRoles();
    UserRole updateUserRole(UserRole userRole,Long id) throws UserRoleNotFoundException;
    void deleteUserRoleById(Long id) throws UserRoleNotFoundException;
    void deleteAllUserRoles();
}
