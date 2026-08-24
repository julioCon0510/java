package com.practicas.app.domain.port.out;

import com.practicas.app.domain.model.Product;

import java.util.List;

/**
 * Output port: product persistence.
 */
public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    boolean existsById(Long id);
}
