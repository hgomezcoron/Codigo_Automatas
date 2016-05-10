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
 *
 * @author Adseglocdom
 */
public class Punto_2 {

    public static void main(String args[]) {
        String[][] funcion = {{"", "a", "b", "c"},{"q0","q1","q1","q3"},{"q1","q2","q1", ""},{"q2","","","q1"},{"q3", "q4", "q5", "q3"},
        {"q4", "q5", "q4",""}, {"q5", "q5","",""}};

        //El estado actual siempre sera q0
        String estado_actual = "q0";

        //Se coloca el conjunto de estados de aceptacion
        String[] estados_aceptacion = {"q1", "q5"};

        //Se crean los objetos buffer para trabajar con la consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String cadena;
            bw.write("Escriba la cadena:");
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
