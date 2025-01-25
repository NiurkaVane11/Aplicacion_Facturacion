package com.miempresa.Programa.GUI.Components;

import javax.swing.JLabel;

public class CustomLabel extends JLabel {
    public CustomLabel() {
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(TOP);
    }

    public CustomLabel(String text) {
        super(text);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(TOP);
    }

}
