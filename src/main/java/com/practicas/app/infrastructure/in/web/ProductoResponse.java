package com.practicas.app.infrastructure.in.web;

import com.practicas.app.domain.model.Producto;

import java.math.BigDecimal;

/**
 * DTO de salida con los datos de un producto.
 */
public record ProductoResponse(
        Long id,
        String nombre,
        BigDecimal precio,
        Integer cantidadStock) {

    public static ProductoResponse fromDomain(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidadStock());
    }
}
