package com.practicas.app.domain.port.in;

import com.practicas.app.domain.model.Producto;

/**
 * Puerto de entrada: caso de uso para registrar un nuevo producto.
 */
public interface RegistrarProductoUseCase {

    Producto registrar(Producto producto);
}
