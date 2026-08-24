package com.practicas.app.domain.port.in;

import com.practicas.app.domain.model.Product;

/**
 * Input port: use case for updating an existing product.
 */
public interface UpdateProductUseCase {

    /**
     * Updates the product identified by {@code id}.
     *
     * @return the updated product, or {@code null} if no product exists with that id.
     */
    Product update(Long id, Product product);
}
