package com.andres.juego.main;

import com.andres.juego.model.*;

public class App{

    static Tablero tablero;
    static Pieza temp;

    static void imprimirTablero(){
        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j< 8; j++){
                temp = tablero.getCasilla(i, j).getPieza();

                if(temp == null){
                    System.out.print("*");
                }else{
                    System.out.print(temp.identificarse());
                }
            }
                System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Prueba de llenado de tablero");

        tablero = new Tablero();

        tablero.llenarTablero();

        System.out.println("Prueba completada");

        imprimirTablero();

        /*
        tablero.moverPieza(1, 0, 3, 0); 
        tablero.moverPieza(3, 0, 4, 0);
        tablero.moverPieza(6, 1, 4, 1);
        tablero.moverPieza(4, 0, 5, 1);
        */

       tablero.moverPieza(1, 0, 3, 0);
       tablero.moverPieza(6, 0, 4, 0);

        imprimirTablero();

    }
}