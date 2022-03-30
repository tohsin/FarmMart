package com.farmmart.service.userrole;

import com.farmmart.data.model.userrole.UserRole;
import com.farmmart.data.model.userrole.UserRoleNotFoundException;
import com.farmmart.data.repository.userrole.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole saveUserRole(UserRole userRole) throws UserRoleNotFoundException {
        UserRole savedUserRole=userRoleRepository.findByRoleName(userRole.getRoleName());
        if (savedUserRole!=null){
            throw new UserRoleNotFoundException("Role already exist");
        }
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole findUserRoleById(Long id) throws UserRoleNotFoundException {
        UserRole userRole=userRoleRepository.findById(id).orElseThrow(()->new UserRoleNotFoundException("User Role Not Found"));

        return userRole;
    }

    @Override
    public UserRole findUserRoleByName(String name) throws UserRoleNotFoundException {
        UserRole userRole=userRoleRepository.findByRoleName(name);
        if (userRole==null){
            throw new UserRoleNotFoundException("User Role Not Found");
        }
        return userRole;
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole updateUserRole(UserRole userRole, Long id) throws UserRoleNotFoundException {
        UserRole savedUserRole=userRoleRepository.findById(id)
                .orElseThrow(()->new UserRoleNotFoundException("User Role Not Found"));

        if (Objects.nonNull(userRole.getRoleName())){
            savedUserRole.setRoleName(userRole.getRoleName());
        }
        return userRoleRepository.save(savedUserRole);
    }

    @Override
    public void deleteUserRoleById(Long id) throws UserRoleNotFoundException {

        userRoleRepository.deleteById(id);

        Optional<UserRole> optionalUserRole=userRoleRepository.findById(id);

        if (optionalUserRole.isPresent()){
            throw new UserRoleNotFoundException("User Role Not Deleted");
        }
    }

    @Override
    public void deleteAllUserRoles() {

        userRoleRepository.deleteAll();
    }
}
