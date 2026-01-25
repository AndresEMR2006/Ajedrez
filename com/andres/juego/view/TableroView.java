package com.andres.juego.view;

import com.andres.juego.controller.juegoController;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class TableroView extends JPanel{

    JButton[][] botones;
    juegoController controlador;

    public TableroView(juegoController controlador){

        JButton aux;
        this.controlador = controlador;

        setLayout(new GridLayout(8,8));
        botones = new JButton[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                aux = new JButton();
                int fila = i;
                int columna = j;

                aux.addActionListener(e -> {
                    controlador.botonPresionado(fila, columna);
                    actualizarCasillas();
                });

                botones[fila][columna] = aux;
                add(botones[fila][columna]);

            }
        }
        System.out.println("Creacion de tablero terminada");
        actualizarCasillas();
    }
    
    void actualizarCasillas(){
        for(int i = 0; i< 8; i++){
            for (int j= 0; j < 8 ; j++){
                char id = controlador.piezaEnCasilla(i,j);
                System.err.println("Id "+ i + " " + j + ": " + id);

                if ((j+i) % 2 == 0) {
                    botones[i][j].setBackground(Color.BLACK);
                }else{
                    botones[i][j].setBackground(Color.WHITE);
                }

                if (controlador.esSeleccionada(i, j)) {
                    botones[i][j].setBackground(Color.RED);
                }

                if(id == ' '){
                    botones[i][j].setText("");
                }else{
                    botones[i][j].setText(String.valueOf(id));
                }
            }
        }
    }


}