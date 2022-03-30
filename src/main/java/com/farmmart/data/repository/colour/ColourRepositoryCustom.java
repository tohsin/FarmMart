package com.farmmart.data.repository.colour;

import com.farmmart.data.model.colour.Colour;
import org.springframework.data.jpa.repository.Query;

public interface ColourRepositoryCustom {

    @Query("From Colour c Where c.colourName Like %?#{[0].toUpperCase()}%")
    Colour findColourByName(String colourName);
}
