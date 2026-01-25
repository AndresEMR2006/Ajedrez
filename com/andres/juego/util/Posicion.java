package com.andres.juego.util;

public class Posicion{

    // Propiedades

    private int fila;
    private int columna;

    // Constructores

    public Posicion(){
    }

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    // Comportamiento

    public boolean posicionValida(){
        return this.columna >= 0 && this.fila >= 0 && this.columna <= Constantes.TAM_TABLERO && this.fila <= Constantes.TAM_TABLERO;
    }

    // Setters

    public void setX(int fila){
        this.fila = fila;
    }

    public void setY(int columna){
        this.columna = columna;
    }

    // Getters

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

}