package com.practicas.app.infrastructure.in.web;

import com.practicas.app.domain.model.Producto;
import com.practicas.app.domain.port.in.ObtenerProductosUseCase;
import com.practicas.app.domain.port.in.RegistrarProductoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Adaptador de entrada: expone el caso de uso de registrar producto vía REST.
 */
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final RegistrarProductoUseCase registrarProductoUseCase;
    private final ObtenerProductosUseCase obtenerProductosUseCase;

    @PostMapping
    public ResponseEntity<ProductoResponse> registrar(@Valid @RequestBody RegistrarProductoRequest request) {
        Producto producto = new Producto(null, request.nombre(), request.precio(), request.cantidadStock());
        Producto registrado = registrarProductoUseCase.registrar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoResponse.fromDomain(registrado));
    }

    @GetMapping
    public List<ProductoResponse> productos() {
        return obtenerProductosUseCase.productos().stream()
                .map(ProductoResponse::fromDomain)
                .toList();
    }
}
