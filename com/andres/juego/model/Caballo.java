package com.andres.juego.model;

import com.andres.juego.util.Posicion;

public class Caballo extends Pieza{

    @Override
    public boolean moverse(Posicion destino, Tablero tablero){

        Posicion origen = this.getPosicion();

        System.out.println("Fila inicial: " + origen.getFila() + " Columna inicial: " + origen.getColumna());
        System.err.println("Fila final: " + destino.getFila() + " Columna final: " + destino.getColumna());

        // Comprobar aliado en el destino 

        System.out.println("Aliado");
        if(!tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !tablero.hayOponente(destino.getFila(), destino.getColumna(), this.getColor())) return false;

        // Logica de movimiento

        // Movimiento 2 vertical
    
        if(origen.getColumna()+2 == destino.getColumna() || origen.getColumna()-2 == destino.getColumna()){
            System.out.println("vertical");
            if(origen.getFila() + 1 == destino.getFila() || origen.getFila() - 1 == destino.getFila()) return true;
        }

        // Movimiento 2 horizontal
        
        if(origen.getFila()+2 == destino.getFila() || origen.getFila()-2 == destino.getFila()){
            System.out.println("horizontal");
            if(origen.getColumna() + 1 == destino.getColumna() || origen.getColumna() - 1 == destino.getColumna()) return true;
        }

        return false;
    }

    @Override
    public char identificarse(){
        return 'C';
    }
}