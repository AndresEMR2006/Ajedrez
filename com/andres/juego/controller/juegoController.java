package com.andres.juego.controller;

import com.andres.juego.model.Tablero;

public class juegoController{

    Tablero tablero;
    int filaSel, columnaSel;
    boolean haySel;

    public juegoController(){
        tablero = new Tablero();
        tablero.llenarTablero();
        haySel = false;
    }

    public void botonPresionado(int fila, int columna){

        System.out.println("Casilla " + fila + " " + columna + " seleccionada");

        if(!haySel){
            seleccionar(fila, columna);
        }else{
            mover(fila, columna);
        }
    }

    void seleccionar(int fila, int columna){
        if(!tablero.casillaVacia(fila, columna)){
            filaSel = fila;
            columnaSel = columna;
            haySel = true;
        }
    }

    void mover(int fila, int columna){
        tablero.moverPieza(filaSel, columnaSel, fila, columna);
        haySel = false;
    }

    public boolean esSeleccionada(int fila, int columna){
        return haySel && (fila == filaSel) && (columna == columnaSel);
    }

    public char piezaEnCasilla(int fila, int columna){
        if(tablero.casillaVacia(fila, columna))return ' ';
        else return tablero.getCasilla(fila, columna).getPieza().identificarse();
    }

}