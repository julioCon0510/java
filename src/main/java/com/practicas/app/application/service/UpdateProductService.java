package com.practicas.app.application.service;

import com.practicas.app.domain.model.Product;
import com.practicas.app.domain.port.in.UpdateProductUseCase;
import com.practicas.app.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Application service implementing the update-product use case.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product update(Long id, Product product) {
        log.info("Updating product by id: {}", id);
        if (!productRepositoryPort.existsById(id)) {
            return null;
        }
        product.setId(id);
        return productRepositoryPort.save(product);
    }
}
