/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 *
 * @author Gederson
 */
public class test {
    
    public static void main(String[] args) throws IOException {
        String comando[] = {"cmd.exe", "/c", "tasklist /v /fo csv"};

        Process proceso = Runtime.getRuntime().exec(comando);

        BufferedReader buff = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String line;
        
        // Leer y descartar la primera línea que contiene los encabezados de columna
        buff.readLine();

        while ((line = buff.readLine()) != null) {
            String[] parts = line.split("\"");
            String nombreProceso = parts[1];
            String pid = parts[3];
            String usoMemoria = parts[9];
            String tiempoCPU = parts[15];
            
            System.out.println("Nombre: " + nombreProceso + " - PID: " + pid + " - Uso de memoria: " + usoMemoria + " - Tiempo de CPU: " + tiempoCPU);
        }

        buff.close();
    }
}
