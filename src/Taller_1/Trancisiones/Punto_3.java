/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller_1.Trancisiones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * dasdas5456.sasdas@25456_dasdas@uniminuto.edu.co
 *
 * @author Adseglocdom
 */
public class Punto_3 {

    public static void main(String args[]) {
        String[][] funcion = {{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "-", "_", "@"},
        /*transcisiones q0 a q1*/  {"q0", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        /*transcisiones q1 a q2*/  {"q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q1", "q2"},
        /*transcisiones q2 a q3u*/ {"q2", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q3", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        /*transcisiones q3 a q4n*/ {"q3", "", "", "", "", "", "", "", "", "", "", "", "", "q4", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        /*transcisiones q4 a q5i*/ {"q4", "", "", "", "", "", "", "", "q5", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q5 a q8min*/{"q5", "", "", "", "", "", "", "", "q7", "", "", "", "q6", "q8", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q8 a q9u*/  {"q8", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q9", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q9 a q1t*/  {"q9", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q10", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q10 a q11o*/{"q10", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q11", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q11 a q12.*/{"q11", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q12", "", "", "", "", ""},
       /*transcisiones q12 a q13e*/{"q12", "", "", "", "q13", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q13 a q14d*/{"q13", "", "", "q14", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q14 a q15u*/{"q14", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q15", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q15 a q16.*/{"q15", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q16", "", "", "", "", ""},
       /*transcisiones q16 a q17c*/{"q16", "", "q17", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
       /*transcisiones q17 a q18o*/{"q17", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "q18", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};

        //El estado actual siempre sera q0
        String estado_actual = "q0";

        //Se coloca el conjunto de estados de aceptacion
        String[] estados_aceptacion = {"q18"};

        //Se crean los objetos buffer para trabajar con la consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String cadena;
            bw.write("Ingrese correo:");
            bw.flush();
            cadena = br.readLine(); //Se lee la cadena desde la consola
            int fila = 0, columna = 0; //Fila y columna donde se encuentra el siguiente estado

            for (int i = 0; i < cadena.length(); i++) //Se recorre la cadena por completo
            {
                //Se recorre la tabla en la columna 0 para encontrar el estado actual
                for (int j = 0; j < funcion.length; j++) {
                    if (estado_actual.equals(funcion[j][0])) //Si el estado actual ha sido encontrado en la tabla
                    {
                        fila = j; //Se guarda la fila correspondiente
                        break; //Como se encuentra, no es necesario recorrer mas
                    }
                }

                //Se recorre la tabla en la fila 0 para encontrar la columna que corresponde al simbolo que se esta procesando
                for (int j = 0; j < funcion[0].length; j++) {
                    if (funcion[0][j].equals(cadena.charAt(i) + "")) //Si el simbolo en la tabla es igual al simbolo procesado
                    {
                        columna = j; //Se guarda la columna correspondiente
                        break; //Como se encuentra la columna, no es necesario recorrer mas
                    }
                }

                //Se guarda el estado al que se mueve
                estado_actual = funcion[fila][columna];

                //Se pregunta si el estado actual llego a una transicion vacia o nula
                if (estado_actual.equals("null")) {
                    break;
                }
            } //Fin del ciclo que recorre la cadena

            //Es falsa hasta que no se compruebe que el ultimo al que llega es un estado de aceptacion
            boolean aceptada = false;

            //Se compara el ultimo estado con el conjunto de estados de aceptacion
            for (int i = 0; i < estados_aceptacion.length; i++) {
                if (estado_actual.equals(estados_aceptacion[i])) //Si el estado actual es de aceptacion
                {
                    aceptada = true;
                    break;
                }
            }

            //Se imprime la informacion
            if (aceptada) {
                bw.write("Cadena aceptada");
            } else {
                bw.write("Cadena rechazada");
            }
            bw.flush();

        } catch (IOException e) {
        }

    }
}
