package com.farmmart.data.model.baseaudit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
public class BaseAudit implements Serializable {

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createdDate;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime modifiedDate;
}
