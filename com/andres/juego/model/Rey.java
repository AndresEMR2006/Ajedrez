package com.andres.juego.model;

import com.andres.juego.util.Funciones;
import com.andres.juego.util.Posicion;

public class Rey extends Pieza{

    @Override
    public boolean moverse(Posicion destino, Tablero tablero){

        Posicion origen = this.getPosicion();
        int movimientoFila, movimientoColumna;

        if(!tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !tablero.hayOponente(destino.getFila(), destino.getColumna(), this.getColor())) return false;

        if(tablero.jaque(destino.getFila(), destino.getColumna(), this.getColor())) return false;

        movimientoFila = origen.getFila() - destino.getFila();
        movimientoColumna = origen.getColumna() - destino.getColumna();

        movimientoColumna = Funciones.valorAbsoluto(movimientoColumna);
        movimientoFila = Funciones.valorAbsoluto(movimientoFila);

        if(movimientoColumna > 1 || movimientoFila > 1) return false;

        return true;
    }

    @Override
    public char identificarse(){
        return 'K';
    }
}