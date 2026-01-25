package com.andres.juego.model;

import com.andres.juego.util.Funciones;
import com.andres.juego.util.Posicion;

public class Reina extends Pieza{

    @Override
    public boolean moverse(Posicion destino, Tablero tablero){
        
        // Prueba aliado en el destino
        if(!tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !tablero.hayOponente(destino.getFila(), destino.getColumna(), this.getColor())) return false;

        Posicion origen = this.getPosicion();
        int movimientoFila, movimientoColumna, movimiento;

        movimientoFila = destino.getFila() - origen.getFila();
        movimientoColumna = destino.getColumna() - origen.getColumna();

        // Confirmacion de diagonalidad
        System.err.println("Prueba diagonalidad");
        if(movimientoColumna != movimientoFila && movimientoColumna * -1 != movimientoFila){

            if(origen.getFila() != destino.getFila() && origen.getColumna() != destino.getColumna()) return false;

            // Logica movimiento vertical
            if(origen.getFila() != destino.getFila()){
                System.out.println("Vertical");
                movimiento = destino.getFila() - origen.getFila();

                while (movimiento != 0){
                    if(origen.getFila() + movimiento == destino.getFila()){
                        movimiento = Funciones.cambioMovimiento(movimiento);
                        continue;
                    }
                    if(!tablero.casillaVacia(origen.getFila() + movimiento, origen.getColumna())){
                        return false;
                    }
                    movimiento = Funciones.cambioMovimiento(movimiento);
                }
            }
    
            // Logica movimiento horizontal
            if (origen.getColumna() != destino.getColumna()) {
                System.out.println("Horizontal");
                movimiento = destino.getColumna() - origen.getColumna();

                while (movimiento != 0){
                    if(origen.getColumna() + movimiento == destino.getColumna()){
                        movimiento = Funciones.cambioMovimiento(movimiento);
                        continue;
                    }
                    if(!tablero.casillaVacia(origen.getFila(), origen.getColumna() + movimiento)) return false;
                    movimiento = Funciones.cambioMovimiento(movimiento);
                }
            }

            return true;
        }

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
        return 'Q';
    }
}