/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.TbPreciosJpaController;
import entidades.TbPrecios;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.Dependent;
//import jakarta.faces.bean.ManagedBean;

import jakarta.inject.Named;

/**
 *
 * @author dionisio.barrantes
 */
@Named
@Dependent
   
public class CalculaPrecioManagedBean     {
    
    
@EJB
TbPreciosJpaController precios;
TbPrecios precioTotal;  
List<TbPrecios> listaPrecios;

    public TbPreciosJpaController getPrecios() {
        return precios;
    }

    public void setPrecios(TbPreciosJpaController precios) {
        this.precios = precios;
    }

    public TbPrecios getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(TbPrecios precioTotal) {
        this.precioTotal = precioTotal;
    }

       
 
    
  public List<TbPrecios> CalculaPrecioManagedBean() {
    
   listaPrecios = precios.findTbPreciosEntities();
  
   return listaPrecios;
  }
   
  public List<TbPrecios> CalculaPrecioManagedBeanParam(Integer modalidadEstancia, String duracionEstancia, Integer tarifa ) {
   
    
    List<TbPrecios> findPrecios = precios.findPrecios(modalidadEstancia, tarifa);
    
    return findPrecios;
    }
    
}
