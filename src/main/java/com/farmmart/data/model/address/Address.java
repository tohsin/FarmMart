package com.farmmart.data.model.address;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends BaseAudit {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String streetNumber;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String city;

    private String postZipCode;

    private String landMark;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private LocalGovernment localGovernment;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<AppUser> appUsers;

}
