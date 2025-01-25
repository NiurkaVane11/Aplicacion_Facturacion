package com.miempresa.Programa.GUI.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import com.miempresa.Producto;
import com.miempresa.ProductoManager;
import com.miempresa.Programa.GUI.Dialogs.Mensajes;

public class GuardarActionListener implements ActionListener {
    private JTextField texto1;
    private JTextField texto2;
    private ProductoManager productoManager;
    private DefaultListModel<String> listModel;

    public GuardarActionListener(JTextField texto1, JTextField texto2, ProductoManager productoManager,
            DefaultListModel<String> listModel) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.productoManager = productoManager;
        this.listModel = listModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener los textos de los campos de texto
        String nombreProducto = texto1.getText();
        double precioProducto;
        try {
            precioProducto = Double.parseDouble(texto2.getText());

            // Verificar que el precio sea positivo
            if (precioProducto <= 0) {
                Mensajes.showErrorMessage("El precio debe ser un número positivo.", "Error de Validación");
                return;
            }
        } catch (NumberFormatException ex) {
            Mensajes.showErrorMessage("El precio debe ser un número.", "Error de Formato");
            return;
        }

        // Crear una nueva instancia de Producto y agregarla a través del
        // ProductoManager
        Producto producto = new Producto(nombreProducto, precioProducto);
        productoManager.agregarProducto(producto);

        // Actualizar el DefaultListModel
        listModel.addElement(producto.toString());

        // Limpiar los campos de texto
        texto1.setText("");
        texto2.setText("");
    }
}