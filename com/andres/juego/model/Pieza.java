package com.andres.juego.model;

import com.andres.juego.util.Color;
import com.andres.juego.util.Posicion;

public abstract class Pieza{

    // Propiedades

    private Color color;
    private Posicion posicion;

    // Contructor
    Pieza(Posicion posicion, Color color) {
        this.posicion = posicion;
        this.color = color;
    }

    Pieza(){}

    // Comportamiento

    public abstract boolean moverse(Posicion destino, Tablero tablero);
    public abstract char identificarse();

    // Setters

    void setColor(Color color){
        this.color = color;
    }

    void setPosicion(int x, int y){
        this.posicion = new Posicion(x, y);
    }

    // Getters

    Color getColor(){
        return this.color;
    }

    Posicion getPosicion(){
        return this.posicion;
    }

}