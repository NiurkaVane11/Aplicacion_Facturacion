package com.miempresa;

import java.util.List;

public class FacturaSimple implements IFactura {

    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0.0; // Inicializar el total en 0

        // Iterar sobre la lista de productos
        for (Producto producto : productos) {
            // Sumar el precio de cada producto al total
            total += producto.getPrecio();
        }

        // Retornar el total calculado
        return total;
    }
}