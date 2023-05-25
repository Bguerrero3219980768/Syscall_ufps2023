/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mario Neta
 */
public class Proceso implements Comparable<Proceso> {
    
    private String nombre;
    private String pid;
    private String usoMemoria;
    private String tiempoCPU;

    public Proceso(String nombre, String pid, String usoMemoria, String tiempoCPU) {
        this.nombre = nombre;
        this.pid = pid;
        this.usoMemoria = usoMemoria;
        this.tiempoCPU = tiempoCPU;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPid() {
        return pid;
    }

    public String getUsoMemoria() {
        return usoMemoria;
    }

    public String getTiempoCPU() {
        return tiempoCPU;
    }

    @Override
    public int compareTo(Proceso otroProceso) {
        return nombre.compareTo(otroProceso.getNombre());
    }
}
