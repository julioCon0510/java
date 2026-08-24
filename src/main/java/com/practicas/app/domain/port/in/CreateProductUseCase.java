package com.practicas.app.domain.port.in;

import com.practicas.app.domain.model.Product;

/**
 * Input port: use case for creating a new product.
 */
public interface CreateProductUseCase {
    Product create(Product product);
}
