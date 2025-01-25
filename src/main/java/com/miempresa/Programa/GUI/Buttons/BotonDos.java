package com.miempresa.Programa.GUI.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;

import com.miempresa.FacturaSimple;
import com.miempresa.ProductoManager;
import com.miempresa.Programa.GUI.Dialogs.Mensajes;

public class BotonDos extends JButton implements ActionListener {

    private ProductoManager productoManager;
    private FacturaSimple facturaSimple;

    public BotonDos(String text, ProductoManager productoManager) {
        super(text);
        this.productoManager = productoManager;
        this.facturaSimple = new FacturaSimple();
        addActionListener(this);
    }

    public BotonDos(Action a) {
        super(a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Calcular el total de la factura
        double total = facturaSimple.calcularTotal(productoManager.getProductos());
        Mensajes.showErrorMessage("El total de la factura es: $" + total, "Total de la Factura");
    }
}