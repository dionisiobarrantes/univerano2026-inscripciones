/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author INAEM-2
 */
public class DeshabilitaBoton {
  

    private boolean disable;

    // default constructor 
    public DeshabilitaBoton(){
       this.disable= false;
    }

    public boolean isDisable() {
       return disable;
    }
    public void setDisable(boolean disable) {
       this.disable = disable;
    }
  
}
