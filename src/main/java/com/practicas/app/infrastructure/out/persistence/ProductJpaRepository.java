package com.practicas.app.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for {@link ProductEntity}.
 */
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
