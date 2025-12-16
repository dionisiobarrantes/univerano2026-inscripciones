/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;


 
@Named
@ViewScoped
public class CaptchaAction implements Serializable{
String validate; 
    public CaptchaAction() {
     }
  
 
    public String getValidate() {
        return validate;
    }
 
    public void setValidate(String validate) {
        this.validate = validate;
    }
 
    public String execute() throws Exception {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Boolean isResponseCorrect = Boolean.FALSE;
        jakarta.servlet.http.HttpSession session = request.getSession();
        String parm = validate;
        String c = (String) session.getAttribute(MyCaptcha.CAPTCHA_KEY);
        if (parm.equals(c)) {
            return "confirmacion";
        } else {
            return "inscripcion";
        }
    }
}