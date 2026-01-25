package com.andres.juego.view;

import com.andres.juego.controller.juegoController;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

    public VentanaPrincipal(){

        configurarVentana();

        juegoController controlador = new juegoController();

        TableroView tablero = new TableroView(controlador);

        add(tablero);
        pack();
        setVisible(true);

    }

    void configurarVentana(){
        setTitle("Ajedrez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
