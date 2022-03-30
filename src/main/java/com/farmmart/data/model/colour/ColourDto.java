package com.farmmart.data.model.colour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColourDto {

    @JsonIgnore
    private Long id;

    private String colourName;
}
