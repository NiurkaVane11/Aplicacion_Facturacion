package com.miempresa.Programa.GUI.Panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.miempresa.Producto;
import com.miempresa.ProductoManager;
import com.miempresa.Programa.GUI.Buttons.BotonDos;
import com.miempresa.Programa.GUI.Buttons.BotonUno;
import com.miempresa.Programa.GUI.Components.CustomLabel;
import com.miempresa.Programa.GUI.Listeners.GuardarActionListener;

public class PanelUno extends JPanel {

    private ProductoManager productoManager;
    private JTextField texto1;
    private JTextField texto2;
    private DefaultListModel<String> listModel;
    private JList<String> texto3;

    public PanelUno() {
        productoManager = new ProductoManager();

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear etiquetas, campos de texto y botón
        CustomLabel etiqueta1 = new CustomLabel("Aplicación de Facturación");
        CustomLabel etiqueta2 = new CustomLabel("Nombre producto: ");
        CustomLabel etiqueta3 = new CustomLabel("Precio producto: ");
        CustomLabel etiqueta4 = new CustomLabel("Lista de productos: ");

        texto1 = new JTextField(15);
        texto2 = new JTextField(15);
        listModel = new DefaultListModel<>();
        texto3 = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(texto3); // Añadir JScrollPane para desplazamiento

        BotonUno boton1 = new BotonUno("Guardar");
        BotonDos boton2 = new BotonDos("Calcular Total", productoManager);

        // Configurar el margen entre los elementos
        constraints.insets = new Insets(11, 11, 11, 11);

        // Configurar la etiqueta principal
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Ocupa dos columnas
        constraints.anchor = GridBagConstraints.CENTER; // Centrar en la celda
        add(etiqueta1, constraints);

        // Configurar la etiqueta del nombre del producto
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // Ocupa una columna
        constraints.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(etiqueta2, constraints);

        // Configurar el campo de texto para el nombre del producto
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL; // Expandir el campo de texto horizontalmente
        add(texto1, constraints);

        // Configurar la etiqueta del precio del producto
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        add(etiqueta3, constraints);

        // Configurar el campo de texto para el precio del producto
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(texto2, constraints);

        // Configurar el botón "Guardar"
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2; // Ocupa dos columnas
        constraints.anchor = GridBagConstraints.CENTER; // Centrar en la celda
        constraints.fill = GridBagConstraints.NONE; // No expandir
        add(boton1, constraints);

        // Configurar el botón "Calcular Total"
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2; // Ocupa dos columnas
        constraints.anchor = GridBagConstraints.CENTER; // Centrar en la celda
        constraints.fill = GridBagConstraints.NONE; // No expandir
        add(boton2, constraints);

        // Configurar la etiqueta de la lista de productos
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2; // Ocupa dos columnas
        constraints.anchor = GridBagConstraints.CENTER;
        add(etiqueta4, constraints);

        // Configurar el JList para la lista de productos
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2; // Ocupa dos columnas
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPane, constraints);

        // Crear y añadir un ActionListener al botón "Guardar"
        GuardarActionListener listener = new GuardarActionListener(texto1, texto2, productoManager, listModel);
        boton1.addActionListener(listener);

        // Cargar productos iniciales en el JList
        actualizarTextoList();
    }

    // Método para actualizar el JList con la lista de productos
    public void actualizarTextoList() {
        listModel.clear(); // Limpiar el modelo de la lista
        for (Producto producto : productoManager.getProductos()) {
            listModel.addElement(producto.toString());
        }
    }
}