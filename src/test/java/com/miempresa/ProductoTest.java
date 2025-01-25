package com.miempresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @Test
    void testProductoConstructor() {
        Producto producto = new Producto("Manzana", 1.50);
        assertEquals("Manzana", producto.getNombre());
        assertEquals(1.50, producto.getPrecio());
    }

    @Test
    void testProductoToString() {
        Producto producto = new Producto("Manzana", 1.50);
        assertEquals("Manzana - $1.50", producto.toString());
    }
}
