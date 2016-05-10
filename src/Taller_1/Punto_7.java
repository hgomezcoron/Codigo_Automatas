/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Adseglocdom
 */
public class Punto_7 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String cadena;
        int i = 0;
        boolean accepted = true;
        try {
            bw.write("Automata #7 // Escriba la cadena: ");
            bw.flush();
            cadena = br.readLine();

            if (i < cadena.length() && cadena.charAt(i) == 'a') {
                i++;

                while (i < cadena.length() && cadena.charAt(i) == 'b') {
                    i++;
                }

                if (i < cadena.length() && cadena.charAt(i) == 'a') {
                    i++;
                    while (i < cadena.length()) {

                        if (i < cadena.length() && cadena.charAt(i) == 'a') {
                            i++;
                            while (i < cadena.length() && cadena.charAt(i) == 'b') {
                                i++;
                            }
                        } else {
                            accepted = false;
                        }
                    }

                } else {
                    accepted = false;
                }
            } else if (i < cadena.length() && cadena.charAt(i) == 'b') {
                i++;

                while (i < cadena.length()) {
                    
                    if (i < cadena.length() && cadena.charAt(i) == 'a') {
                        i++;
                     while (i < cadena.length() && cadena.charAt(i) == 'b') {
                        i++;
                    }}else {
                        accepted = false;
                    }
                }
            } else {
                accepted = false;
            }
            if (accepted) {
                bw.write("Cadena valida");
                bw.flush();
            } else {
                bw.write("Cadena NO valida");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
