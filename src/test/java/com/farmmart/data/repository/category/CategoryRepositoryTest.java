package com.farmmart.data.repository.category;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.category.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    Category category;

    @BeforeEach
    void setUp() {
        category=new Category();
    }

    @Test
    void testThatYouSaveProductCategory(){

        category.setCategoryName("Tool");

        log.info("Product category {} repo before saving", category);

        assertDoesNotThrow(()->categoryRepository.save(category));

        log.info("Product category {} repo after saving",category);
    }

    @Test
    void testThatYouCanFindCategoryById() throws CategoryNotFoundException {
        Long id=40L;
        category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category id NotFound"));

        assertEquals(40,category.getId(),"IDs are not equal");

        log.info("Category {}", category);
    }

    @Test
    void testThatYouCanFindCategoryByName() throws CategoryNotFoundException {

        String name="Aqua";
        category=categoryRepository.findByCategoryName(name);

        log.info("Category name {}", category);
    }

    @Test
    void testThatYouCanFindAllCategories(){
        List<Category> categories=categoryRepository.findAll();

        log.info("All categories {}", categories);
    }

    @Test
    void testThatYouCanDeleteCategoryById() throws CategoryNotFoundException {
        Long id=35L;
        categoryRepository.deleteById(id);

        Optional<Category> optionalCategory=categoryRepository.findById(id);

        if (optionalCategory.isPresent()){
            throw new CategoryNotFoundException("Category is Not Deleted");
        }
    }

    @Test
    void testThatYouCanDeleteAllCategories(){
        categoryRepository.deleteAll();
    }



}