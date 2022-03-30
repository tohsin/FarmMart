package com.farmmart.data.model.employee;


import com.farmmart.data.model.staticdata.RelationshipWithNextOfKin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyEmployeeAdmin {

    private Long id;

    private String firstName;

    private String lastName;

    private String otherNames;

    private String nextOfKin;

    private RelationshipWithNextOfKin relationshipWithNextOfKin;

}
