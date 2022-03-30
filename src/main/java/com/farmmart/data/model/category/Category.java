package com.farmmart.data.model.category;

import com.farmmart.data.model.baseaudit.BaseAudit;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseAudit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String categoryName;

}
