package com.practicas.app.infrastructure.in.web;

import com.practicas.app.domain.model.Product;

import java.math.BigDecimal;

/**
 * Output DTO with the data of a product.
 */
public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        Integer stockQuantity) {

    public static ProductResponse fromDomain(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity());
    }
}
