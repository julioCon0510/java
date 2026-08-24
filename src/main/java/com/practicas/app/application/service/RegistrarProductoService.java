package com.practicas.app.application.service;

import com.practicas.app.domain.model.Producto;
import com.practicas.app.domain.port.in.RegistrarProductoUseCase;
import com.practicas.app.domain.port.out.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de aplicación que implementa el caso de uso de registrar un producto.
 */
@Service
@RequiredArgsConstructor
public class RegistrarProductoService implements RegistrarProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    @Override
    public Producto registrar(Producto producto) {
        return productoRepositoryPort.guardar(producto);
    }
}
