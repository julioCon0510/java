package com.practicas.app.domain.port.in;

import com.practicas.app.domain.model.Producto;

import java.util.List;

public interface ObtenerProductosUseCase {
    List<Producto> productos();
}
