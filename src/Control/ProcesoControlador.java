/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Negocio.ProcesoNegocio;
import Vista.ProcesoVista;

/**
 *
 * @author Mario Neta
 */
public class ProcesoControlador {
    
    private ProcesoVista procesoVista;
    private ProcesoNegocio procesoNegocio;

    public ProcesoControlador(ProcesoVista vista, ProcesoNegocio gestorProcesos) {
        this.procesoVista = vista;
        this.procesoNegocio = gestorProcesos;
    }
}
