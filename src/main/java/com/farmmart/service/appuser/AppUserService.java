package com.farmmart.service.appuser;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.appuser.AppUserNotFoundException;
import com.farmmart.data.model.appuser.AppUserSignInDto;
import com.farmmart.data.model.staticdata.Role;
import com.farmmart.data.model.staticdata.UserType;
import com.farmmart.data.model.userrole.UserRole;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser) throws AppUserNotFoundException;

    void addRoleToUser(String username,String roleName);

//    AppUser login(AppUser appUser) throws AppUserNotFoundException;

    AppUser findUserById(Long id) throws AppUserNotFoundException;

    AppUser findUserByUsername(String username) throws AppUserNotFoundException;

    AppUser findUserByPhoneNumber(String phone) throws AppUserNotFoundException;

    AppUser findUserByEmail(String email) throws AppUserNotFoundException;

    List<AppUser> findUserByType(UserType userType);

    List<AppUser> findAllUsers();//TODO pagination

    AppUser updateUser(AppUser appUser,Long id) throws AppUserNotFoundException;

    void deleteUserById(Long id) throws AppUserNotFoundException;

    void deleteAllUsers();


}
