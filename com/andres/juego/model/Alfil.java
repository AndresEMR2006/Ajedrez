package com.andres.juego.model;

import com.andres.juego.util.Funciones;
import com.andres.juego.util.Posicion;

public class Alfil extends Pieza{

    @Override
    public boolean moverse(Posicion destino, Tablero tablero){

        // Prueba aliado en el destino
        if(!tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !tablero.hayOponente(destino.getFila(), destino.getColumna(), this.getColor())) return false;

        Posicion origen = this.getPosicion();
        int movimientoFila, movimientoColumna;

        movimientoFila = destino.getFila() - origen.getFila();
        movimientoColumna = destino.getColumna() - origen.getColumna();

        // Confirmacion de diagonalidad
        System.err.println("Prueba diagonalidad");
        if(movimientoColumna != movimientoFila && movimientoColumna * -1 != movimientoFila) return false;

        while (movimientoColumna != 0){
            if(origen.getColumna() + movimientoColumna == destino.getColumna() && origen.getFila() + movimientoFila == destino.getFila()){
                movimientoColumna = Funciones.cambioMovimiento(movimientoColumna);
                movimientoFila = Funciones.cambioMovimiento(movimientoFila);
                continue;
            }
            // Prueba casillas vacia
            if(!tablero.casillaVacia(origen.getFila() + movimientoFila, origen.getColumna() + movimientoColumna)) return false;
                movimientoColumna = Funciones.cambioMovimiento(movimientoColumna);
                movimientoFila = Funciones.cambioMovimiento(movimientoFila);
            }     

        return true;
    }

    @Override
    public char identificarse(){
        return 'A';
    }
}