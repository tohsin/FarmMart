package com.farmmart.data.repository.userrole;

import com.farmmart.data.model.userrole.UserRole;
import com.farmmart.data.model.userrole.UserRoleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class UserRoleRepositoryTest {

    @Autowired
    private UserRoleRepository userRoleRepository;

    UserRole userRole;

    @BeforeEach
    void setUp() {
        userRole=new UserRole();
    }

    @Test
    void testThatYouCanSaveUserRole(){
        userRole.setRoleName("Role_CUSTOMER");

        assertDoesNotThrow(()->userRoleRepository.save(userRole));

        log.info("UserRole repo {}",userRole);
    }

    @Test
    void testThatYouCanFinerUserRoleById() throws UserRoleNotFoundException {
        Long id=4L;
        userRole=userRoleRepository.findById(id).orElseThrow(()->new UserRoleNotFoundException("Role Not Found"));

        assertEquals(id,userRole.getId());

        log.info("Role Id 4 {}",userRole);
    }

    @Test
    void testThatYouCanFindRoleByName() throws UserRoleNotFoundException {
        String name="ROLE_ADMIN";

        userRole=userRoleRepository.findByRoleName(name);

        if (userRole==null){
            throw new UserRoleNotFoundException("Role Not Found");
        }

        assertEquals(name,userRole.getRoleName());

        log.info("Role: {}",userRole);
    }

    @Test
    void testThatYouCanFindAllRoles(){
        List<UserRole> userRoleList=userRoleRepository.findAll();
        Integer size=6;

        assertEquals(size,userRoleList.size());

        log.info("Role size {}",userRoleList.size());

        log.info("Roles {}",userRoleList);

    }

    @Test
    void testThatYouCanUpdateRole() throws UserRoleNotFoundException {
        Long id=5L;
        userRole=userRoleRepository.findById(id).orElseThrow(()->new UserRoleNotFoundException("Role Not Found"));
        String roleNameUpdate="ROLE_DEFAULT";
        userRole.setRoleName(roleNameUpdate);

        assertDoesNotThrow(()->userRoleRepository.save(userRole));

        assertEquals(roleNameUpdate,userRole.getRoleName());

        log.info("Updated Role Name {}", userRole.getRoleName());
    }

    @Rollback
    @Test
    void testThatYouCanDeleteRoleById() throws UserRoleNotFoundException {
        Long id=1L;
        userRoleRepository.deleteById(id);

        Optional<UserRole> optionalUserRole=userRoleRepository.findById(id);

        if (optionalUserRole.isPresent()){
            throw new UserRoleNotFoundException("Role Not Deleted");
        }

        log.info("Deleted role {}",userRole.getRoleName());
    }

    @Rollback
    @Test
    void testThatYouCAnDeleteAllRoles(){
        userRoleRepository.deleteAll();
    }
}