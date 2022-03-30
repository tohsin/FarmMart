package com.farmmart.service.userrole;

import com.farmmart.data.model.userrole.UserRole;
import com.farmmart.data.model.userrole.UserRoleNotFoundException;
import com.farmmart.data.repository.userrole.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert.sql"})
@Slf4j
class UserRoleServiceImplTest {

    @Mock
    private UserRoleRepository userRoleRepository;

    @InjectMocks
    private UserRoleService userRoleService=new UserRoleServiceImpl();

    UserRole userRole;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userRole=new UserRole();
    }

    @Test
    void testThatYouCanMockSaveUserRoleMethod() throws UserRoleNotFoundException {
        Mockito.when(userRoleRepository.save(userRole)).thenReturn(userRole);

        userRoleService.saveUserRole(userRole);

        ArgumentCaptor<UserRole> userRoleArgumentCaptor=ArgumentCaptor.forClass(UserRole.class);

        Mockito.verify(userRoleRepository,Mockito.times(1)).save(userRoleArgumentCaptor.capture());

        UserRole capturedUserRole=userRoleArgumentCaptor.getValue();

        assertEquals(capturedUserRole,userRole);
    }

    @Test
    void testThatYouCanMockFindUserRoleByIdMethod() throws UserRoleNotFoundException {
        Long id=3L;
        Mockito.when(userRoleRepository.findById(id)).thenReturn(Optional.of(userRole));

        userRoleService.findUserRoleById(id);

        Mockito.verify(userRoleRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void testThatYouCanMockFindUserRoleByNameMethod() throws UserRoleNotFoundException {

        String name= "EMPLOYEE";

        Mockito.when(userRoleRepository.findByRoleName(name)).thenReturn(userRole);

        userRoleService.findUserRoleByName(name);

        Mockito.verify(userRoleRepository,Mockito.times(1)).findByRoleName(name);
    }

    @Test
    void testThatYouCanMockFindAllUserRolesMethod() {
        List<UserRole> userRoleList=new ArrayList<>();

        Mockito.when(userRoleRepository.findAll()).thenReturn(userRoleList);

        userRoleService.findAllUserRoles();

        Mockito.verify(userRoleRepository,Mockito.times(1)).findAll();
    }

    @Test
    void testThatYouCanMockUpdateUserRoleMethod() throws UserRoleNotFoundException {
        Long id=1L;
        Mockito.when(userRoleRepository.findById(id)).thenReturn(Optional.of(userRole));

        userRoleService.updateUserRole(userRole,id);

        Mockito.verify(userRoleRepository,Mockito.times(1)).save(userRole);
    }

    @Test
    void testThatYouCanMockDeleteUserRoleByIdMethod() throws UserRoleNotFoundException {

        Long id=5L;
        doNothing().when(userRoleRepository).deleteById(id);

        userRoleService.deleteUserRoleById(id);

        verify(userRoleRepository,times(1)).deleteById(id);
    }

    @Test
    void testThatYouCanMockDeleteAllUserRolesMethod() {
        doNothing().when(userRoleRepository).deleteAll();

        userRoleService.deleteAllUserRoles();

        verify(userRoleRepository,times(1)).deleteAll();
    }
}