package com.andres.juego.main;

import com.andres.juego.view.VentanaPrincipal;

public class Gui{
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}