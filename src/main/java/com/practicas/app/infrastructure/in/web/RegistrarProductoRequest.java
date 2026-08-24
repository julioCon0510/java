package com.practicas.app.infrastructure.in.web;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * DTO de entrada para registrar un producto.
 */
public record RegistrarProductoRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
        BigDecimal precio,

        @NotNull(message = "La cantidad en stock es obligatoria")
        @Min(value = 0, message = "La cantidad en stock no puede ser negativa")
        Integer cantidadStock) {
}
