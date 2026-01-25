package com.andres.juego.model;

import com.andres.juego.util.Color;
import com.andres.juego.util.Posicion;

public class Peon extends Pieza{

    public Peon(Posicion posicion, Color color){
        super(posicion, color);
    }

    @Override
    public boolean moverse(Posicion destino, Tablero tablero){

        // Variables
        Posicion origen = this.getPosicion();
        int direccion, initPos;
        boolean passant = false;

        // Obtener el color para saber hacia que direccion es el movimiento (?

        if(this.getColor() == Color.BLANCO){
            direccion = 1;
            initPos = 1;
        } else {
            direccion = -1;
            initPos = 6;
        }

        // Confirmacion de movimiento al paso
        System.err.println("Tablero passant: " + tablero.getPassant());

        if(tablero.getPassant()){
            if(origen.getFila() + direccion == destino.getFila()){
                if (origen.getColumna() + 1 == destino.getColumna() || origen.getColumna() - 1  == destino.getColumna()) {
                    passant = true;
                }
            }
        }
        System.out.println("Passant: " + passant);

        if(tablero.casillaVacia(destino.getFila(), destino.getColumna()) && !passant){
            System.out.println("movimiento");

            // logica movimiento
            System.out.println("origen fila: " + origen.getFila() + " columna: " + origen.getColumna());
            System.out.println("destino fila: " + destino.getFila() + " columna: " + destino.getColumna());

            if(origen.getFila() == initPos){

                    // Logica primer movimiento
                    System.out.println("primer movimiento " + origen.getFila() + " = " + destino.getFila());
                    // Comprobracion de si se movio hacia los lados
                    if(origen.getColumna() != destino.getColumna()) return false;
                    System.err.println("1");
                    // Comprobamos si se movio mas de 1 o 2
                    if(origen.getFila() + (direccion*2) != destino.getFila() 
                    && origen.getFila() + direccion != destino.getFila()) return false;
                    System.err.println("2");
                    // Comprobacion de si al moverse 2 habia una ficha en medio
                    if((origen.getFila() + (direccion*2) == destino.getFila()) 
                    && !tablero.casillaVacia(destino.getFila()- direccion , destino.getColumna() )) return false;
                    System.err.println("3");

                }else{
                    System.out.println("cualquier movimiento");

                    // Logica movimiento cualquiera

                    if(origen.getColumna() != destino.getColumna()) return false;
                    if(origen.getFila() + direccion != destino.getFila()) return false;
                }
            
        }else{
            System.out.println("captura");

            // Logica de captura
            System.err.println("0");
            if(!tablero.hayOponente(destino.getFila(),destino.getColumna(), this.getColor()) && !tablero.getPassant()) return false;
            System.err.println("1");
            if(!(destino.getColumna() == origen.getColumna()-1 || destino.getColumna() == origen.getColumna()+1)) return false;
            System.err.println("2");
            if(origen.getFila() + direccion != destino.getFila()) return false;
            System.err.println("3");
        }

        return true;
    }

    @Override
    public char identificarse(){
        return 'P';
    }

}