package controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import dao.InscripcionesJpaController;
import dao.TbCamasJpaController;
import dao.TbCcaaJpaController;
import dao.TbModalidadEstanciaJpaController;
import dao.TbOcupacionJpaController;
import dao.TbOrganizacionJpaController;
import dao.TbOrientacionAlimentarioJpaController;
import dao.TbPreciosJpaController;
import dao.TbTarifaJpaController;
import dao.VistaPreciosJpaController;
import entidades.Inscripciones;
import entidades.TbCcaa;
import entidades.TbModalidadEstancia;
import entidades.TbOcupacion;
import entidades.TbOrganizacion;
import entidades.TbOrientacionAlimentario;
import entidades.TbPrecios;
import entidades.TbTarifa;
import entidades.VistaPrecios;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;

import jakarta.mail.AuthenticationFailedException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.mail.MessagingException;
//import jakarta.servlet.http.HttpServletRequest;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.ResourceBundle;


/**
 *
 * @author dioni
 */
@Named(value = "newJSFManagedBean")
@SessionScoped
public class NewJSFManagedBean implements Serializable
       {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
  
@PersistenceContext(unitName = "my_persistence_unit")   

@EJB TbCcaaJpaController ccaaDAO;
@EJB TbOrientacionAlimentarioJpaController orientacionAlimentariaDAO;
@EJB InscripcionesJpaController inscripcionDAO;
@EJB TbOcupacionJpaController ocupacionDAO;
@EJB TbOrganizacionJpaController organizacionDAO;      
@EJB TbModalidadEstanciaJpaController modalidadEstanciaDAO;     
@EJB TbTarifaJpaController tarifaDAO;    
@EJB TbPreciosJpaController preciosDAO;  
    
    @jakarta.inject.Inject
    SendMailTLS correoConfirmacion; // El servidor lo crea por ti

TbCcaa ccaa;
TbOrientacionAlimentario orientacionAlimentaria;
TbOcupacion ocupacion;
TbOrganizacion organizacion;
TbTarifa tarifa;
TbModalidadEstancia modalidadEstancia;
TbPrecios precios;

List<TbCcaa> listaCCAA;    
List<TbOrientacionAlimentario> listaOrientacionAlimentaria;
List<TbOcupacion> listaOcupaciones;
List<TbOrganizacion> listaOrganizacion;
 
Short tipo_cama;
String cadenaBusqueda;
Short idBusqueda;
List<String> listaDias;
Short importe_calculado = 0;
Integer antes_despues;
String correoElectronico2;
Boolean pillado = Boolean.FALSE;
String mensaje = ".";
String deshabilitador = "False";
Boolean valorBooleano = Boolean.FALSE;
String validate;
    
    Integer codCCAA;
    Inscripciones inscripcionActual;
     private final EntityManagerFactory emf = null;
     private EntityManager em;
     
    private List<TbPrecios> listaSalida ;
    List<TbModalidadEstancia> listaModalidadEstancia;
    List<TbPrecios> listaPrecios;
    List<TbTarifa> listaTarifa;

List<VistaPrecios>  listaVistaPrecios;


    private TbPrecios salida;
  

    public NewJSFManagedBean () {
         
        Boolean isResponseCorrect = Boolean.FALSE;
         inscripcionActual = new Inscripciones();
    String[] array = new String[]{"T"};
        listaDias = Arrays.asList(array);
        
         
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public List<TbCcaa> getListaCCAA() {
        return listaCCAA;
    }

    public void setListaCCAA(List<TbCcaa> listaCCAA) {
        this.listaCCAA = listaCCAA;
    }

    public List<TbOcupacion> getListaOcupaciones() {
        listaOcupaciones = ocupacionDAO.findTbOcupacionEntities();
        return listaOcupaciones;
    }

    public void setListaOcupaciones(List<TbOcupacion> listaOcupaciones) {
        this.listaOcupaciones = listaOcupaciones;
    }

    public List<TbOrganizacion> getListaOrganizacion() {
         listaOrganizacion = organizacionDAO.findTbOrganizacionEntities();
        return listaOrganizacion;
    }

    public void setListaOrganizacion(List<TbOrganizacion> listaOrganizacion) {
        this.listaOrganizacion = listaOrganizacion;
    }

   
    
    public Integer getCodCCAA() {
        return codCCAA;
    }

    public void setCodCCAA(Integer codCCAA) {
        this.codCCAA = codCCAA;
    }

    public List<TbCcaa> muestraCCAA() {

        listaCCAA = ccaaDAO.findTbCcaaEntities();

        return listaCCAA;
    }

    public List<TbOrientacionAlimentario> getListaOrientacionAlimentaria() {
        return listaOrientacionAlimentaria;
    }

    public void setListaOrientacionAlimentaria(List<TbOrientacionAlimentario> listaOrientacionAlimentaria) {
        this.listaOrientacionAlimentaria = listaOrientacionAlimentaria;
    }
 
    public List<TbOrientacionAlimentario> muestraOrientacionAlimentaria() {

        listaOrientacionAlimentaria = orientacionAlimentariaDAO.findTbOrientacionAlimentarioEntities();

        return listaOrientacionAlimentaria;
    }

    public TbModalidadEstancia getModalidadEstancia() {
        return modalidadEstancia;
    }

    public void setModalidadEstancia(TbModalidadEstancia modalidadEstancia) {
        this.modalidadEstancia = modalidadEstancia;
    }
    
    public Inscripciones getInscripcionActual() {
        return inscripcionActual;
    }

    public void setInscripcionActual(Inscripciones inscripcionActual) {
        this.inscripcionActual = inscripcionActual;
    }

    public String getCorreoElectronico2() {
        return correoElectronico2;
    }

    public void setCorreoElectronico2(String correoElectronico2) {
        this.correoElectronico2 = correoElectronico2;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public List<TbModalidadEstancia> getListaModalidadEstancia() {
        return listaModalidadEstancia;
    }

    public void setListaModalidadEstancia(List<TbModalidadEstancia> listaModalidadEstancia) {
        this.listaModalidadEstancia = listaModalidadEstancia;
    }

    public List<String> getListaDias() {
        return listaDias;
    }

    public void setListaDias(List<String> listaDias) {
        this.listaDias = listaDias;
    }

  public Short calculaImporte() throws IOException,MessagingException {
     
        ResourceBundle bundle = ResourceBundle.getBundle("resources.mensajes", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String valuekeyFechaLimite = bundle.getString("fecha_limite");      
       if ((inscripcionActual.getModalidadEstancia() == 1 ) 
               || (inscripcionActual.getModalidadEstancia() == 2 )
                || (inscripcionActual.getModalidadEstancia() == 6 )
                || (inscripcionActual.getModalidadEstancia() == 9 )
                || (inscripcionActual.getModalidadEstancia() == 10 )
                || (inscripcionActual.getModalidadEstancia() == 13 )
                || (inscripcionActual.getModalidadEstancia() == 14 )
                || (inscripcionActual.getModalidadEstancia() == 15 )
                || (inscripcionActual.getModalidadEstancia() == 16 )
                || (inscripcionActual.getModalidadEstancia() == 17 )
               
               )
       {
       
       String[] array = new String[]{"T"};
       listaDias = Arrays.asList(array);
       }
       if (listaDias.isEmpty())
       {     
       inscripcionActual.setDuracionEstancia("[1..5]");   
       }
       else
       { 
        inscripcionActual.setDuracionEstancia(listaDias.toString());  
             
       }    
       List<Predicate> predicates = new ArrayList<Predicate>();        
       Date d = new Date();
       Date fecha_limite = new Date();
       inscripcionActual.setFechaInscripcion(d);
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         try {

             fecha_limite = df.parse(valuekeyFechaLimite);

         } catch (ParseException e) {
             e.printStackTrace();
         }
       if (inscripcionActual.getModalidadEstancia().shortValue()> 0)
        {
       if (fecha_limite.compareTo(inscripcionActual.getFechaInscripcion())== -1) antes_despues = 1 ;
        else antes_despues=0 ;
        }
       listaSalida = muestraPrecios(inscripcionActual.getModalidadEstancia(),inscripcionActual.getTarifa(),antes_despues);
       
      if (listaSalida.isEmpty())
             importe_calculado = 0;
        else
        {    
        salida = listaSalida.get(0);
        if (inscripcionActual.getDuracionEstancia().equals("[T]"))
           inscripcionActual.setImporteTotal((short)salida.getPrecio());
        else{ 
           inscripcionActual.setImporteTotal((short)(salida.getPrecio()*(short) listaDias.size()));
           
//          if (inscripcionActual.getModalidadEstancia().equals(5))
//          {   
//          if (inscripcionActual.getMediapension().equals(Boolean.TRUE))  
//          {short mp;
//               mp = (short)2;
//                inscripcionActual.setImporteTotal((short)(inscripcionActual.getImporteTotal()/mp));
//           }
//       }
        
        }  
        importe_calculado = inscripcionActual.getImporteTotal();
        }
      return importe_calculado;
     }
    public List<TbModalidadEstancia> muestraModalidadEstancia() {
 //       listaModalidadEstancia = modalidadEstanciaDAO.findTbModalidadEstanciaEntities(); 
       listaModalidadEstancia = modalidadEstanciaDAO.findAllVisibles(); 
        this.listaModalidadEstancia = listaModalidadEstancia;
        return listaModalidadEstancia;
    }

    public List<TbPrecios> getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(List<TbPrecios> listaPrecios) {
        this.listaPrecios = listaPrecios;
    }
    
    public List<TbPrecios> muestraPrecios(Integer modalidadEstancia, Integer tarifa,Integer antes_despues) {
        this.listaPrecios = preciosDAO.findPreciosCalculadora(modalidadEstancia, tarifa, antes_despues); 
        return listaPrecios;
    }
    public List<TbTarifa> getListaTarifa() {
        if (listaTarifa == null) {
            listaTarifa = tarifaDAO.findAllVisibles();
        }
        return listaTarifa;
    }

    public Short getImporte_calculado() {
        return importe_calculado;
    }

    public void setImporte_calculado(Short importe_calculado) {
        this.importe_calculado = importe_calculado;
    }
    
    public String execute() throws Exception {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Boolean isResponseCorrect = Boolean.FALSE;
        Boolean noHayDuplicados = Boolean.TRUE;
        
       
      
        jakarta.servlet.http.HttpSession session = (jakarta.servlet.http.HttpSession) request.getSession();
        String parm = validate;
        String c = (String) session.getAttribute(MyCaptcha.CAPTCHA_KEY);
        if (parm.equals(c)) 
        {
            inscripcionActual.setImporteTotal(this.calculaImporte());
            noHayDuplicados = inscripcionDAO.doInscripcionesDuplicadosCount(inscripcionActual.getDniNie(), inscripcionActual.getDuracionEstancia(), inscripcionActual.getModalidadEstancia()) ;
            if (noHayDuplicados)
            {    
            this.doGuardarInscripcion();
            return "confirmacion";
            }
            else 
            {
             FacesContext facesContext = FacesContext.getCurrentInstance();
             FacesMessage hayDuplicados = new FacesMessage("Ya existe una inscripción con el mismo DNI, modalidad de estancia y duracion");
             facesContext.addMessage("ficha_inscripcion:dniNie", hayDuplicados);
                return "inscripcion";
        }
    }
        return "inscripcion";
    }
        public String doGuardarInscripcion() throws IOException,MessagingException, jakarta.mail.MessagingException, Exception{
         
            
  
        inscripcionActual.setEstado(1);
        inscripcionActual.setImportePagado("0");
        inscripcionDAO.create(inscripcionActual);
        
        try{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        jakarta.servlet.http.HttpSession session = (jakarta.servlet.http.HttpSession) request.getSession();
            
//        SendMailTLS correoConfirmacion = new SendMailTLS(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale()); 
        System.out.println(inscripcionActual.getIdInscripcion());
        correoConfirmacion.enviaCorreo(inscripcionActual.getIdInscripcion().toString(), inscripcionActual.getCorreoElectronico(), inscripcionActual.getImporteTotal().toString(),FacesContext.getCurrentInstance().getExternalContext().getRequestLocale() );
        setCorreoElectronico2(""); 
        
        }
        catch(IOException e)
                {
                    System.out.println("Error en envio de correo");
                    throw new AuthenticationFailedException("Connect failed", e);
                }
        return "confirmacion" ;  
    }

           public TbTarifa getTarifa() {
               return tarifa;
           }

           public void setTarifa(TbTarifa tarifa) {
               this.tarifa = tarifa;
           }

       }
