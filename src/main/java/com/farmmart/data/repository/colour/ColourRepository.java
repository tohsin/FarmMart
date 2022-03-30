package com.farmmart.data.repository.colour;

import com.farmmart.data.model.colour.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends JpaRepository<Colour,Long>, ColourRepositoryCustom {
}
