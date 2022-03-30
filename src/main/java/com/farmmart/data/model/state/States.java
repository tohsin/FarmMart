package com.farmmart.data.model.state;

import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class States extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Add State name")
    private String stateName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Country country;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "state",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<LocalGovernment> localGovernments;

    public void addLocalGovernment(LocalGovernment localGovernment){
        if (localGovernments==null){
            localGovernments=new HashSet<>();
        }
        localGovernments.add(localGovernment);

        localGovernment.setState(this);
    }
}
