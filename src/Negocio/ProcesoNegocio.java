/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Proceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Mario Neta
 */
public class ProcesoNegocio {
    
    public List<Proceso> obtenerProcesos() {
        List<Proceso> procesos = new ArrayList<>();

        try {
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

                Proceso procesoObj = new Proceso(nombreProceso, pid, usoMemoria, tiempoCPU);
                procesos.add(procesoObj);
            }

            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordenar la lista de procesos alfabéticamente
        Collections.sort(procesos);

        return procesos;
    }
    
    public void matarProceso(String pid) throws IOException {
        String comando[] = {"cmd.exe", "/c", "taskkill /F /PID " + pid };
        Runtime.getRuntime().exec(comando);
    }
}
