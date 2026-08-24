package com.practicas.app.infrastructure.in.web;

import com.practicas.app.domain.model.Product;
import com.practicas.app.domain.port.in.CreateProductUseCase;
import com.practicas.app.domain.port.in.GetProductUseCase;
import com.practicas.app.domain.port.in.UpdateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Input adapter: exposes the product use cases over REST.
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        Product product = new Product(null, request.name(), request.price(), request.stockQuantity());
        Product created = createProductUseCase.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.fromDomain(created));
    }

    @GetMapping
    public List<ProductResponse> products() {
        return getProductUseCase.products().stream()
                .map(ProductResponse::fromDomain)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> productById(@PathVariable Long id) {
        Product product = getProductUseCase.productById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductResponse.fromDomain(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateProductRequest request) {
        Product product = new Product(null, request.name(), request.price(), request.stockQuantity());
        Product updated = updateProductUseCase.update(id, product);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductResponse.fromDomain(updated));
    }
}
