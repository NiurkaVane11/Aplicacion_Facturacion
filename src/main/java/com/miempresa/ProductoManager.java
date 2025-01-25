package com.miempresa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoManager {

    private List<Producto> productos;

    public ProductoManager() {
        productos = new ArrayList<>();
        cargarProductosDesdeArchivo();
    }

    // Método para guardar la lista de productos en un archivo de texto
    public void guardarProductosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto producto : productos) {
                writer.write(producto.getNombre() + "," + producto.getPrecio());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar la lista de productos desde un archivo de texto
    public void cargarProductosDesdeArchivo() {
        productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("productos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    double precio = Double.parseDouble(parts[1]);
                    productos.add(new Producto(nombre, precio));
                }
            }
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, se crea una nueva lista vacía
            productos = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la lista de productos
    public List<Producto> getProductos() {
        return productos;
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductosEnArchivo();
    }
}