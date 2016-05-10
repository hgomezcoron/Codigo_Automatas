/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/**
 *
 * @author Adseglocdom
 */
public class Punto_4 {
    public static void main(String args[]) {

        String[][] tablaDeTransiciones = {
            // Estado Actual
            {"q0", "q0", "q0", "q0", "q0", "q0", "q0"},
            // Simbolo
            {"a", "b", "a", "b", "a", "b", "-"},
            // Tope actual
            {"Z0", "Z0", "A", "B", "B", "A", "Z0"},
            // Estado siguiente
            {"q0", "q0", "q0", "q0", "q0", "q0", "q1"},
            // Tope nuevo
            {"A", "B", "A", "B", "-", "-", ""}};

        // El estado actual siempre sera q0
        String estadoActual = "q0";

        // El estado actual siempre sera q0
        String estadoAceptacion = "q1";

        // Se crea la pila
        Stack<String> pila = new Stack<String>();

        // Se inicializa la pila con Z0
        pila.push("Z0");

        boolean aceptada = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bw.write("Automata de Pila #4 // Escriba la cadena: ");
            bw.flush();
            String cadena = br.readLine() + "-";
            boolean proceso = true;
            for (int i = 0; i < cadena.length(); i++) {
                if (proceso) {
                    proceso = false;
                    String tope = pila.pop();
                    pila.push(tope);
                    String simboloActual = cadena.charAt(i) + "";
                    for (int j = 0; j < tablaDeTransiciones[0].length; j++) {
                        if (estadoActual.equals(tablaDeTransiciones[0][j])) {
                            if (simboloActual.equals(tablaDeTransiciones[1][j])) {
                                if (tope.equals(tablaDeTransiciones[2][j])) {
                                    estadoActual = tablaDeTransiciones[3][j];
                                    if (tablaDeTransiciones[4][j].equals("-")) {
                                        pila.pop();
                                    } else {
                                        for (int k = 0; k < tablaDeTransiciones[4][j].length(); k++) {
                                            pila.push(tablaDeTransiciones[4][j]).charAt(k);
                                        }
                                    }
                                    proceso = true;
                                    break;
                                }
                            }
                        }
                        if (j >= tablaDeTransiciones[0].length) {
                            aceptada = false;
                            break;
                        }
                    }
                }
            }
            if (pila.pop().equals("Z0") && estadoAceptacion.contains(estadoActual)) {
                aceptada = true;
            }
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
