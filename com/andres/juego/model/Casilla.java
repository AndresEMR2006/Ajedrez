package com.andres.juego.model;

import com.andres.juego.util.Color;

public class Casilla{

    // Propiedades

    private Color color;
    private Pieza pieza;

    // Contructores

    Casilla(Color color) {
        this.color = color;
        this.pieza = null;
    }

    Casilla(){
    }

    // Comportamiento

    public void vaciar(){
        this.pieza = null;
    }

    // Setters

    void setPieza(Pieza pieza){
        this.pieza = pieza;
    }

    void setColor(Color color){
        this.color = color;
    }

    // Getters

    public Pieza getPieza(){
        return this.pieza;
    }

    public Color getColor(){
        return this.color;
    }

}