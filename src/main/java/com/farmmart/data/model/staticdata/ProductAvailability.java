package com.farmmart.data.model.staticdata;

public enum ProductAvailability {
    IN_STOCK("In Stock"),
    OUT_OF_STOCK("Out of Stock");


    private final String productAvailability;

    ProductAvailability(String productAvailability) {
        this.productAvailability = productAvailability;
    }

    public String getProductAvailability() {
        return productAvailability;
    }

    @Override
    public String toString() {
        return "ProductAvailability{" +
                "productAvailability='" + productAvailability + '\'' +
                '}';
    }
}
