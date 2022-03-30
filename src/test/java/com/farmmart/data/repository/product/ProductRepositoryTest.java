package com.farmmart.data.repository.product;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.colour.Colour;
import com.farmmart.data.model.product.Product;
import com.farmmart.data.model.product.ProductNotFoundException;
import com.farmmart.data.model.staticdata.ProductAvailability;
import com.farmmart.data.model.staticdata.ProductCondition;
import com.farmmart.data.model.staticdata.UnitOfMeasure;
import com.farmmart.data.model.vendor.Vendor;
import com.farmmart.data.repository.category.CategoryRepository;
import com.farmmart.data.repository.colour.ColourRepository;
import com.farmmart.data.repository.vendor.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
@Transactional
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ColourRepository colourRepository;

    Product product;

    Vendor vendor;

    Category category;

    Colour colour;

    @BeforeEach
    void setUp() {

        product=new Product();
        vendor=new Vendor();
        category=new Category();
        colour=new Colour();
    }

    @Test
    void testThatYouCanSaveProduct(){
        vendor=vendorRepository.findById(1L).orElseThrow();

        category=categoryRepository.findById(18L).orElseThrow();

        colour=colourRepository.findById(1L).orElseThrow();

        Colour colour1=colourRepository.findById(2L).orElseThrow();

        Set<Colour> colours=new HashSet<>();
        colours.add(colour);
        colours.add(colour1);

        product.setVendor(vendor);
        product.setCategory(category);
        product.setColours(colours);
        product.setProductType("Pepper");
        product.setProductSKU("H234");
        product.setProductName("Habernero");
        product.setProductStyle(null);
        product.setProductCondition(ProductCondition.DRY);
        product.setBrand("Zero Waste Farms");
        product.setPartNumber(null);
        product.setPrice(BigDecimal.valueOf(36.00));
        product.setProductAvailability(ProductAvailability.IN_STOCK);
        product.setProductDescription("Hot pepper that comes in different colors");
        product.setProductDimension(null);
        product.setStockQuantity(50);
        product.setUnitOfMeasure(UnitOfMeasure.PKT);
        product.setWeight(null);

        log.info("Product repo {} before saving",product);

        assertDoesNotThrow(()->productRepository.save(product));

        assertEquals(50,product.getStockQuantity());

        assertEquals("Pepper",product.getProductType());

        log.info("Product repo after saving {}",product);
    }

    @Test
    void testThatYouCanFindProductById() throws ProductNotFoundException {
        Long id=4L;
        product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found"));

        assertEquals(4,product.getId());

        log.info("Product: {}", product.getProductName());
    }

    @Test
    void testThatYouCanFindProductByType() throws ProductNotFoundException {
        String productType="Tomato";

        List<Product> products=productRepository.findProductByType(productType);

        if (products.isEmpty()){
            throw new ProductNotFoundException("Product type Not Found");
        }

        log.info("Product -->{}", products);
    }

    @Test
    void testThatYouCanFindProductByName() throws ProductNotFoundException {
        String productName="Sun Gold";

        List<Product> products=productRepository.findProductByName(productName);

        if (products.isEmpty()){
            throw new ProductNotFoundException("Product name Not Found");
        }

        log.info("Product -->{}", products);
    }

    @Test
    void testThatYouCanFindProductByBrand() throws ProductNotFoundException {
        String productBrand="Hoss";

        List<Product> products=productRepository.findProductByBrand(productBrand);

        if (products.isEmpty()){
            throw new ProductNotFoundException("Product brand Not Found");
        }

        log.info("Product -->{}", products);
    }

    @Test
    void testThatYouCanFindProductByPriceLessThanOrEqualsTo(){
        BigDecimal priceLessThanOrEqualsTo=BigDecimal.valueOf(6000);

        List<Product> products=productRepository.findProductByPriceLessThanOrEqualsTo(priceLessThanOrEqualsTo);

        log.info("Product price Less than or equals 6000 --> {}", products);
    }

    @Test
    void testThatYouCanFindProductByPriceGreaterThanOrEqualsTo(){

        BigDecimal priceGreaterThanOrEqualsTo=BigDecimal.valueOf(6000);

        List<Product> products=productRepository.findProductByPriceGreaterThanOrEqualsTo(priceGreaterThanOrEqualsTo);

        log.info("Product price Greater than or equals 6000 --> {}", products);
    }

    @Test
    void testThatYouCanFindProductsByPriceRange(){
        BigDecimal minPrice=BigDecimal.valueOf(4000);

        BigDecimal maxPrice=BigDecimal.valueOf(16000);

        List<Product> products=productRepository.findProductByPriceRange(minPrice, maxPrice);

        log.info("Products by price range -->{}", products);
    }


    @Test
    void testThatYouCanFindProductByPartNumber(){
        String productPartNumber="H2346316";

        List<Product> products=productRepository.findProductByPartNumber(productPartNumber);

        log.info("Fetch product by part number -->{}", products);
    }

    @Test
    void testThatYouCanFindProductByCategory(){

        String categoryName ="Seeds and Seedlings";
        category=categoryRepository.findByCategoryName(categoryName);

        List<Product> productsByCategory=productRepository.findProductByCategory(category);

        log.info("Product by Category -->{}", productsByCategory);
    }


    @Test
    void testThatYouCanFindProductsByVendor(){

        String vendorName="Zero Waste Farms";

        Vendor vendor=vendorRepository.findByName(vendorName);

        List<Product> productsByVendor=productRepository.findProductByVendor(vendor);

        log.info("Products by Vendo -->{}", productsByVendor);
    }

    @Test
    void testThatYouCanFindAllProducts(){
        List<Product> products=productRepository.findAll();

        log.info("Products -->{}", products);
    }

    @Test
    void testThatYouCanUpdateProduct() throws ProductNotFoundException {
        Long id =1L;
        product=productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));

        product.setStockQuantity(100);

        assertDoesNotThrow(()->productRepository.save(product));

        assertEquals(100,product.getStockQuantity());

        log.info("Product quantity -->{}", product.getStockQuantity());
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteProductById() throws ProductNotFoundException {

        Long id= 3L;
        productRepository.deleteById(id);

        Optional<Product> optionalProduct=productRepository.findById(id);

        if (optionalProduct.isPresent()){
            throw new ProductNotFoundException("Product ID "+id+" is Not Deleted");
        }
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteALlProductS(){
        productRepository.deleteAll();
    }


}