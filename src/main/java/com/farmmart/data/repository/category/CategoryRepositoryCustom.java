package com.farmmart.data.repository.category;

import com.farmmart.data.model.category.Category;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepositoryCustom {

    @Query("FROM Category c WHERE c.categoryName LIKE %?#{[0].toUpperCase()}%")
    Category findByCategoryName(String categoryName);
}
