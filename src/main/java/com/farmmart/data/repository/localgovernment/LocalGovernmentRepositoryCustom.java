package com.farmmart.data.repository.localgovernment;

import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.farmmart.data.model.state.States;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalGovernmentRepositoryCustom {

    @Query("FROM LocalGovernment l WHERE l.localGovernmentName Like %?#{[0].toUpperCase()}%")
    LocalGovernment findByLocalGovernmentName(String localGovernmentName);

    @Query("FROM LocalGovernment l WHERE l.state=?1")
    List<LocalGovernment> findLocalGovernmentByState(States state);
}
