/**
 * Clase VentanaUno crea, la primera ventana que mostrara el programa
 *
 * 
 */
package com.miempresa.Programa.GUI.Forms;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.miempresa.Programa.GUI.Panels.PanelUno;

public class VentanaUno extends JFrame {

    // constructor
    public VentanaUno() {
        setTitle("");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon(
                "C:\\Users\\USUARIO\\AplicacionDeFacturacion\\src\\main\\java\\com\\miempresa\\Programa\\GUI\\Resources\\1.jpeg");
        setIconImage(image.getImage());

        PanelUno panel1 = new PanelUno();
        add(panel1, BorderLayout.CENTER);
    }

}
