package com.practicas.app.domain.port.in;

import com.practicas.app.domain.model.Product;

import java.util.List;

/**
 * Input port: use case for reading products.
 */
public interface GetProductUseCase {
    List<Product> products();
    Product productById(Long id);
}
