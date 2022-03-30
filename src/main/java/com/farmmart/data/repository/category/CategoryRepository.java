package com.farmmart.data.repository.category;

import com.farmmart.data.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>,CategoryRepositoryCustom {
}
