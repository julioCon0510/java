package com.practicas.app.application.service;

import com.practicas.app.domain.model.Product;
import com.practicas.app.domain.port.in.CreateProductUseCase;
import com.practicas.app.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Application service implementing the create-product use case.
 */
@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product create(Product product) {
        return productRepositoryPort.save(product);
    }
}
