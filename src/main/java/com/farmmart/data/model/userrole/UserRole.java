package com.farmmart.data.model.userrole;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.baseaudit.BaseAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "userRoles",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<AppUser> appUsers;

}
