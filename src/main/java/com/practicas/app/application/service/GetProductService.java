package com.practicas.app.application.service;

import com.practicas.app.domain.model.Product;
import com.practicas.app.domain.port.in.GetProductUseCase;
import com.practicas.app.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public List<Product> products() {
        log.info("Fetching all products");
        return productRepositoryPort.findAll();
    }

    @Override
    public Product productById(Long id) {
        log.info("Fetching product by id: {}", id);
        return productRepositoryPort.findById(id);
    }
}
