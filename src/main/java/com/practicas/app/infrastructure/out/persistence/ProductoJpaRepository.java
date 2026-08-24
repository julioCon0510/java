package com.practicas.app.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA para {@link ProductoEntity}.
 */
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {
}
