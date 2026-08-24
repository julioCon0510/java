package com.practicas.app.infrastructure.out.persistence;

import com.practicas.app.domain.model.Producto;
import com.practicas.app.domain.port.out.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Adaptador de salida: implementa el puerto {@link ProductoRepositoryPort} usando JPA.
 */
@Component
@RequiredArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoJpaRepository jpaRepository;

    @Override
    public Producto guardar(Producto producto) {
        ProductoEntity guardada = jpaRepository.save(toEntity(producto));
        return toDomain(guardada);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private ProductoEntity toEntity(Producto producto) {
        return new ProductoEntity(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidadStock());
    }

    private Producto toDomain(ProductoEntity entity) {
        return new Producto(
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getCantidadStock());
    }
}
