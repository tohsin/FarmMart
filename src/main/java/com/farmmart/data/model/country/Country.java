package com.farmmart.data.model.country;

import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.state.States;
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
public class Country extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Add Country name")
    private String countryName;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<States> states;

    public void addState(States state){
        if (states==null) {
            states = new HashSet<>();
        }
        states.add(state);

        state.setCountry(this);
    }
}
