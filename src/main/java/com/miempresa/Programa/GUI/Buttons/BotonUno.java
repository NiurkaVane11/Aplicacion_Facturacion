package com.miempresa.Programa.GUI.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BotonUno extends JButton implements ActionListener {

    private JTextField texto1;

    // Constructor que recibe un texto
    public BotonUno(String text) {
        super(text);
        addActionListener(this); // Añadir el action listener al botón
    }

    // Método para establecer la referencia al campo de texto
    public void setTextField(JTextField texto1) {
        this.texto1 = texto1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el texto del campo de texto
        if (texto1 != null) {
            String dato = texto1.getText();
            // Aquí puedes agregar el código para manejar el dato obtenido
            System.out.println("Texto obtenido: " + dato);
            // Limpiar el campo de texto después de obtener el dato
            texto1.setText("");
        } else {
            System.out.println("El campo de texto no ha sido inicializado.");
        }
    }
}