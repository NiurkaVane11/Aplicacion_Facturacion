package com.miempresa;

import com.miempresa.Programa.GUI.Forms.VentanaUno;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaUno ventana = new VentanaUno();
                ventana.setVisible(true);
            }
        });
    }

}