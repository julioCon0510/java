package com.practicas.app.domain.port.out;

import com.practicas.app.domain.model.Producto;

import java.util.List;

/**
 * Puerto de salida: persistencia de productos.
 */
public interface ProductoRepositoryPort {
    Producto guardar(Producto producto);
    List<Producto> obtenerProductos();
}
