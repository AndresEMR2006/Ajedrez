package com.andres.juego.model;

import com.andres.juego.util.Color;
import com.andres.juego.util.Constantes;
import com.andres.juego.util.Posicion;

public class Tablero{

    // Propiedades

    private Casilla[][] casillas;
    Color turno = Color.BLANCO;
    boolean passant;

    // Constructor
    public Tablero(){
        casillas = new Casilla[8][8];

        int index;
        for(int filas = 0; filas < Constantes.TAM_TABLERO; filas++){
            for(int columnas = 0; columnas < Constantes.TAM_TABLERO; columnas++){
                index = filas + columnas;
                if(index%2 == 0){
                    casillas[filas][columnas] = new Casilla(Color.NEGRO);
                }else{
                    casillas[filas][columnas] = new Casilla(Color.BLANCO);
                }
            }
        }
    }

    // Comportamiento

    void colocarPeones(){
        Pieza aux;
        
        for(int columnas = 0; columnas < Constantes.TAM_TABLERO; columnas++){
            aux = new Peon(new Posicion(1, columnas), Color.BLANCO);
            casillas[1][columnas].setPieza(aux);
            aux = new Peon(new Posicion(6, columnas), Color.NEGRO);
            casillas[6][columnas].setPieza(aux);
        }

    }

    void colocarPiezasMayores(Color color){
        int fila;
        Pieza[] piezas;

        if(color == Color.BLANCO){
            fila = 0;
            piezas = Constantes.piezas1;
        }else{
            fila = 7;
            piezas = Constantes.piezas2;
        }

        for(int columnas = 0; columnas < Constantes.TAM_TABLERO; columnas++){
            casillas[fila][columnas].setPieza(piezas[columnas]);
            casillas[fila][columnas].getPieza().setColor(color);
            casillas[fila][columnas].getPieza().setPosicion(fila,columnas);
        }

    }

    public void llenarTablero(){
        colocarPeones();
        colocarPiezasMayores(Color.BLANCO);
        colocarPiezasMayores(Color.NEGRO);
    }

    public boolean casillaVacia(int fila, int columna){
        if(casillas[fila][columna].getPieza() == null){
            return true;
        }else{
            return false;
        }
    }

    public boolean hayOponente(int fila, int columna, Color colorPropio){
        if(casillas[fila][columna].getPieza() == null){
            return false;
        }

        return casillas[fila][columna].getPieza().getColor() != colorPropio;
    }

    public void moverPieza(int fila1, int columna1, int fila2, int columna2){

        boolean captura;

        System.out.println("Fila inicial: " + fila1 + " Columna inicial: " + columna1);
        System.err.println("Fila final: " + fila2 + " Columna final: " + columna2);

        if(casillaVacia(fila1, columna1)) {
            System.err.println("No hay pieza que mover");
            return;
        }

        captura = casillaVacia(fila2, columna2);

        if(movimientoValido(fila1, columna1, fila2, columna2)){

            // Datos para coronar y captura al paso

            passant = false;
            if(getCasilla(fila1, columna1).getPieza() instanceof Peon){
                System.out.println("Si es peon");
                if(fila1 == 1 || fila1 == 6){
                    System.out.println("Si hay movimiento desde incio");
                    if(fila2 == 3 || fila2 == 4){
                        System.out.println("Si hay movimiento de 2 de largo");
                        passant = true;
                    }
                }
            }

            if(casillas[fila1][columna1].getPieza().getColor() != turno){
                System.out.println("Error en el turno");
                return;
            }

            if(captura){
                // movimiento normal 
                if(columna1 == columna2){
                    casillas[fila2][columna2].setPieza(casillas[fila1][columna1].getPieza());
                    casillas[fila2][columna2].getPieza().setPosicion(fila2, columna2);
                    casillas[fila1][columna1].vaciar();
                    System.out.println("Pieza movida correctamente");
                }else{

                    int direccion;
                    if(getCasilla(fila1, columna1).getPieza().getColor() == Color.BLANCO){
                        direccion = 1;
                    }else{
                        direccion = -1;
                    }

                    casillas[fila2][columna2].setPieza(casillas[fila1][columna1].getPieza());
                    casillas[fila2][columna2].getPieza().setPosicion(fila2, columna2);
                    casillas[fila1][columna1].vaciar();
                    casillas[fila2 - direccion][columna2].vaciar();
                    System.err.println("Movimiento en paso realizado correctamente");
                }
                
            }else{
                //Captura
                casillas[fila2][columna2].setPieza(casillas[fila1][columna1].getPieza());
                casillas[fila2][columna2].getPieza().setPosicion(fila2, columna2);
                casillas[fila1][columna1].vaciar();
                System.out.println("Pieza capturada correctamente");
            }

            if(turno == Color.BLANCO){
                turno = Color.NEGRO;
            }else{
                turno = Color.BLANCO;
            }

        }else{
            System.err.println("Movimiento invalido");
        }

    }

    public boolean movimientoValido(int fila1, int columna1, int fila2, int columna2){
        return getCasilla(fila1, columna1).getPieza().moverse(new Posicion(fila2, columna2), this);
    }

    public boolean jaque(int fila, int columna, Color color){

        for(int fila_ = 0; fila_ < 8; fila_++){
            for(int columna_ = 0; columna_ < 8; columna_++){
                Pieza pieza = casillas[fila_][columna_].getPieza();
                if(pieza == null) continue;
                if(pieza.getColor() != color){
                    if(movimientoValido(fila_, columna_, fila, columna)){
                        return true;
                    }
                }

            }
        }
        return false;
        
    }

    // Setters

    public void setCasilla(int x, int y, Casilla casilla){
        this.casillas[x][y] = casilla;
    }

    public boolean getPassant(){
        return this.passant;
    }

    // Getters

    public Casilla getCasilla(int fila, int columna){
        return casillas[fila][columna];
    }

}