package com.farmmart.data.model.localgovernment;

import com.farmmart.data.model.state.States;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyLocalGovernment {

    private Long id;

    private String localGovernmentName;

    private States state;
}
