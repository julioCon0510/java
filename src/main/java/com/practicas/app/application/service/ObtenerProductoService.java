package com.practicas.app.application.service;

import com.practicas.app.domain.model.Producto;
import com.practicas.app.domain.port.in.ObtenerProductosUseCase;
import com.practicas.app.domain.port.out.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObtenerProductoService implements ObtenerProductosUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    @Override
    public List<Producto> productos() {
        log.info(":: Todos los productos -->::");
        return productoRepositoryPort.obtenerProductos();
    }
}
