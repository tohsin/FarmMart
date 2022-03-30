package com.farmmart.data.model.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyService {

    private Long id;

    private String serviceDescription;
}
