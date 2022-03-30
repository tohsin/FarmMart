package com.farmmart.data.model.appuser;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.staticdata.UserType;
import com.farmmart.data.model.userrole.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Email(message = "Email is already taken")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,
            CascadeType.PERSIST,CascadeType.REFRESH})
    private Collection<Address> addresses;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Collection<UserRole> userRoles;

}
