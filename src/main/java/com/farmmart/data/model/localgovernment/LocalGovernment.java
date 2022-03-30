package com.farmmart.data.model.localgovernment;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.state.States;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LocalGovernment extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Add Local Government Name")
    private String localGovernmentName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private States state;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "localGovernment",cascade = CascadeType.ALL)
    private Set<Address> addresses;


    public void addAddress(Address address){
        if (addresses==null){
            addresses=new HashSet<>();
        }

        addresses.add(address);

        address.setLocalGovernment(this);
    }

}