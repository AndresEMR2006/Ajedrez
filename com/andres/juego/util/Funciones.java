package com.andres.juego.util;

public class Funciones{

    public static int cambioMovimiento(int movimiento){

        if(movimiento<0){
            movimiento++;
        }else{
            movimiento--;
        }
        return movimiento;
    }
    
    public static int valorAbsoluto(int numero){
        if(numero < 0){
            return numero*-1;
        }else{
            return numero;
        }
    }

}