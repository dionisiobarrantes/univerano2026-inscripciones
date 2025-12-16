/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import jakarta.inject.Named;

@Named
@Dependent
/**
 *
 * @author dionisio.barrantes
 */
public class SelectManyCheckboxBean implements Serializable {
    
    public List<DiasOcupacionCama> ocupacioncama = new ArrayList<DiasOcupacionCama>();
	 
    public List<String> diasSeleccionados;
    
    public SelectManyCheckboxBean() {
        this.diasSeleccionados = new ArrayList<>();
        {
        this.ocupacioncama.add(new DiasOcupacionCama(1,"Día 18"));
	this.ocupacioncama.add(new DiasOcupacionCama(2,"Día 19"));
        this.ocupacioncama.add(new DiasOcupacionCama(3,"Día 20"));
	this.ocupacioncama.add(new DiasOcupacionCama(4,"Día 21"));
        this.ocupacioncama.add(new DiasOcupacionCama(5,"Día 22"));

    }
   
    }
    public List<DiasOcupacionCama> getOcupacioncama() {
        return ocupacioncama;
    }

    public void setOcupacioncama(List<DiasOcupacionCama> ocupacioncama) {
        this.ocupacioncama = ocupacioncama;
    }

    public List<String> getDiasSeleccionados() {
        return diasSeleccionados;
    }

    public void setDiasSeleccionados(List<String> diasSeleccionados) {
        this.diasSeleccionados = diasSeleccionados;
    }

    public List<String> getdiasSeleccionados() {
        return diasSeleccionados;
    }

    public void setdiasSeleccionados(List<String> diasSeleccionados) {
        this.diasSeleccionados = diasSeleccionados;
    }
    
}
