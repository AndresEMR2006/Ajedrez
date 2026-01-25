package com.andres.juego.model;

import com.andres.juego.util.Color;
import com.andres.juego.util.Funciones;
import com.andres.juego.util.Posicion;

public class Torre extends Pieza{

    // Contructor
    public Torre(){
        super();
    }

    public Torre(Posicion posicion, Color color){
        super(posicion, color);
    }

    // Comportamiento

    @Override
    public boolean moverse(Posicion destino, Tablero tablero) {

        Posicion origen = this.getPosicion();
        int movimiento;

        if(origen.getFila() != destino.getFila() && origen.getColumna() != destino.getColumna()) return false;
        System.out.println("1");
        if(!tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !tablero.hayOponente(destino.getFila(), destino.getColumna(), this.getColor())) return false;
        System.out.println("2");

        // Lógica de movimiento de la torre (horizontal y vertical)

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

    @Override
    public char identificarse() {
        return 'T';
    }
}