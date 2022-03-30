package com.farmmart.data.model.employee;

import com.farmmart.data.model.staticdata.RelationshipWithNextOfKin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyEmployee {

    //TODO only admin can modify most of employee details. Employees should only modify password and address
    private Long id;

    private String nextOfKin;

    private RelationshipWithNextOfKin relationshipWithNextOfKin;

}
