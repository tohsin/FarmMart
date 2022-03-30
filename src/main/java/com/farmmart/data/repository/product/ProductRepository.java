package com.farmmart.data.repository.product;

import com.farmmart.data.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, ProductRepositoryCustom {

    @Query("From Product p Where p.price Between  ?1 And ?2")
    List<Product> findProductByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
