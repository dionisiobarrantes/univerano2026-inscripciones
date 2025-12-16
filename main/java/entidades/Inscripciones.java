/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dioni
 */
@Entity
@Table(name = "inscripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripciones.findAll", query = "SELECT i FROM Inscripciones i"),
    @NamedQuery(name = "Inscripciones.findByIdInscripcion", query = "SELECT i FROM Inscripciones i WHERE i.idInscripcion = :idInscripcion"),
    @NamedQuery(name = "Inscripciones.findByNombreApellidos", query = "SELECT i FROM Inscripciones i WHERE i.nombreApellidos = :nombreApellidos"),
    @NamedQuery(name = "Inscripciones.findByFechaInscripcion", query = "SELECT i FROM Inscripciones i WHERE i.fechaInscripcion = :fechaInscripcion"),
    @NamedQuery(name = "Inscripciones.findByDuracionEstancia", query = "SELECT i FROM Inscripciones i WHERE i.duracionEstancia = :duracionEstancia"),
    @NamedQuery(name = "Inscripciones.findByModalidadEstancia", query = "SELECT i FROM Inscripciones i WHERE i.modalidadEstancia = :modalidadEstancia"),
    @NamedQuery(name = "Inscripciones.findByEdad", query = "SELECT i FROM Inscripciones i WHERE i.edad = :edad"),
    @NamedQuery(name = "Inscripciones.findByDniNie", query = "SELECT i FROM Inscripciones i WHERE i.dniNie = :dniNie"),
    @NamedQuery(name = "Inscripciones.findByCorreoElectronico", query = "SELECT i FROM Inscripciones i WHERE i.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Inscripciones.findByTelefono", query = "SELECT i FROM Inscripciones i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "Inscripciones.findByOcupacion", query = "SELECT i FROM Inscripciones i WHERE i.ocupacion = :ocupacion"),
    @NamedQuery(name = "Inscripciones.findByOtraOcupacion", query = "SELECT i FROM Inscripciones i WHERE i.otraOcupacion = :otraOcupacion"),
    @NamedQuery(name = "Inscripciones.findByOrganizacion", query = "SELECT i FROM Inscripciones i WHERE i.organizacion = :organizacion"),
    @NamedQuery(name = "Inscripciones.findByOtraOrganizacion", query = "SELECT i FROM Inscripciones i WHERE i.otraOrganizacion = :otraOrganizacion"),
    @NamedQuery(name = "Inscripciones.findByAfiliacionSindical", query = "SELECT i FROM Inscripciones i WHERE i.afiliacionSindical = :afiliacionSindical"),
    @NamedQuery(name = "Inscripciones.findBySindicato", query = "SELECT i FROM Inscripciones i WHERE i.sindicato = :sindicato"),
    @NamedQuery(name = "Inscripciones.findByOrientacionAlimentaria", query = "SELECT i FROM Inscripciones i WHERE i.orientacionAlimentaria = :orientacionAlimentaria"),
    @NamedQuery(name = "Inscripciones.findByCiudadResidencia", query = "SELECT i FROM Inscripciones i WHERE i.ciudadResidencia = :ciudadResidencia"),
    @NamedQuery(name = "Inscripciones.findByCcaa", query = "SELECT i FROM Inscripciones i WHERE i.ccaa = :ccaa"),
    @NamedQuery(name = "Inscripciones.findByGuarderia", query = "SELECT i FROM Inscripciones i WHERE i.guarderia = :guarderia"),
    @NamedQuery(name = "Inscripciones.findByEdadNinio", query = "SELECT i FROM Inscripciones i WHERE i.edadNinio = :edadNinio"),
    @NamedQuery(name = "Inscripciones.findByObservaciones", query = "SELECT i FROM Inscripciones i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "Inscripciones.findByTarifa", query = "SELECT i FROM Inscripciones i WHERE i.tarifa = :tarifa"),
    @NamedQuery(name = "Inscripciones.findByImporteTotal", query = "SELECT i FROM Inscripciones i WHERE i.importeTotal = :importeTotal"),
    @NamedQuery(name = "Inscripciones.findByImportePagado", query = "SELECT i FROM Inscripciones i WHERE i.importePagado = :importePagado"),
    @NamedQuery(name = "Inscripciones.findByVerificado", query = "SELECT i FROM Inscripciones i WHERE i.verificado = :verificado"),
    @NamedQuery(name = "Inscripciones.findByNodni", query = "SELECT i FROM Inscripciones i WHERE i.nodni = :nodni"),
    @NamedQuery(name = "Inscripciones.findByDniTutor", query = "SELECT i FROM Inscripciones i WHERE i.dniTutor = :dniTutor"),
    @NamedQuery(name = "Inscripciones.findByNTienda", query = "SELECT i FROM Inscripciones i WHERE i.nTienda = :nTienda"),
    @NamedQuery(name = "Inscripciones.findByObservacionesOrganizacion", query = "SELECT i FROM Inscripciones i WHERE i.observacionesOrganizacion = :observacionesOrganizacion"),
    @NamedQuery(name = "Inscripciones.findByFechaLlegada", query = "SELECT i FROM Inscripciones i WHERE i.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "Inscripciones.findByEstado", query = "SELECT i FROM Inscripciones i WHERE i.estado = :estado"),
    @NamedQuery(name = "Inscripciones.findByColabora", query = "SELECT i FROM Inscripciones i WHERE i.colabora = :colabora"),
    @NamedQuery(name = "Inscripciones.findByMediapension", query = "SELECT i FROM Inscripciones i WHERE i.mediapension = :mediapension"),
    @NamedQuery(name = "Inscripciones.findByFechaActualizacion", query = "SELECT i FROM Inscripciones i WHERE i.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Inscripciones.findByColaboraLudoteca", query = "SELECT i FROM Inscripciones i WHERE i.colaboraLudoteca = :colaboraLudoteca"),
    @NamedQuery(name = "Inscripciones.findByDatosLudoteca", query = "SELECT i FROM Inscripciones i WHERE i.datosLudoteca = :datosLudoteca"),
    @NamedQuery(name = "Inscripciones.findByAlergias", query = "SELECT i FROM Inscripciones i WHERE i.alergias = :alergias"),
    @NamedQuery(name = "Inscripciones.findByAlergiasBoolean", query = "SELECT i FROM Inscripciones i WHERE i.alergiasBoolean = :alergiasBoolean"),
    @NamedQuery(name = "Inscripciones.findByLanzadera", query = "SELECT i FROM Inscripciones i WHERE i.lanzadera = :lanzadera"),
    @NamedQuery(name = "Inscripciones.findByVacunacion", query = "SELECT i FROM Inscripciones i WHERE i.vacunacion = :vacunacion")})
public class Inscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inscripcion")
    private Short idInscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_apellidos")
    private String nombreApellidos;
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;
    @Size(max = 100)
    @Column(name = "duracion_estancia")
    private String duracionEstancia;
    @Column(name = "modalidad_estancia")
    private Integer modalidadEstancia;
    @Column(name = "edad")
    private Integer edad;
    @Size(max = 20)
    @Column(name = "DNI_NIE")
    private String dniNie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "ocupacion")
    private Integer ocupacion;
    @Size(max = 50)
    @Column(name = "otra_ocupacion")
    private String otraOcupacion;
    @Column(name = "organizacion")
    private Integer organizacion;
    @Size(max = 100)
    @Column(name = "otra_organizacion")
    private String otraOrganizacion;
    @Column(name = "afiliacion_sindical")
    private Boolean afiliacionSindical;
    @Size(max = 40)
    @Column(name = "sindicato")
    private String sindicato;
    @Column(name = "orientacion_alimentaria")
    private Integer orientacionAlimentaria;
    @Size(max = 60)
    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;
    @Column(name = "ccaa")
    private Integer ccaa;
    @Column(name = "guarderia")
    private Boolean guarderia;
    @Column(name = "edad_ninio")
    private Integer edadNinio;
    @Size(max = 550)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "tarifa")
    private Integer tarifa;
    @Column(name = "importe_total")
    private Short importeTotal;
    @Size(max = 10)
    @Column(name = "importe_pagado")
    private String importePagado;
    @Column(name = "verificado")
    private Short verificado;
    @Column(name = "NODNI")
    private Boolean nodni;
    @Size(max = 10)
    @Column(name = "dni_tutor")
    private String dniTutor;
    @Column(name = "n_tienda")
    private Integer nTienda;
    @Size(max = 200)
    @Column(name = "observaciones_organizacion")
    private String observacionesOrganizacion;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "colabora")
    private Boolean colabora;
    @Column(name = "mediapension")
    private Boolean mediapension;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "colabora_ludoteca")
    private Short colaboraLudoteca;
    @Size(max = 100)
    @Column(name = "datos_ludoteca")
    private String datosLudoteca;
    @Size(max = 100)
    @Column(name = "alergias")
    private String alergias;
    @Column(name = "alergias_boolean")
    private Boolean alergiasBoolean;
    @Column(name = "lanzadera")
    private Boolean lanzadera;
    @Column(name = "vacunacion")
    private Short vacunacion;

    public Inscripciones() {
    }

    public Inscripciones(Short idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Inscripciones(Short idInscripcion, String nombreApellidos, String correoElectronico) {
        this.idInscripcion = idInscripcion;
        this.nombreApellidos = nombreApellidos;
        this.correoElectronico = correoElectronico;
    }

    public Short getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Short idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getDuracionEstancia() {
        return duracionEstancia;
    }

    public void setDuracionEstancia(String duracionEstancia) {
        this.duracionEstancia = duracionEstancia;
    }

    public Integer getModalidadEstancia() {
        return modalidadEstancia;
    }

    public void setModalidadEstancia(Integer modalidadEstancia) {
        this.modalidadEstancia = modalidadEstancia;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDniNie() {
        return dniNie;
    }

    public void setDniNie(String dniNie) {
        this.dniNie = dniNie;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Integer ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getOtraOcupacion() {
        return otraOcupacion;
    }

    public void setOtraOcupacion(String otraOcupacion) {
        this.otraOcupacion = otraOcupacion;
    }

    public Integer getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Integer organizacion) {
        this.organizacion = organizacion;
    }

    public String getOtraOrganizacion() {
        return otraOrganizacion;
    }

    public void setOtraOrganizacion(String otraOrganizacion) {
        this.otraOrganizacion = otraOrganizacion;
    }

    public Boolean getAfiliacionSindical() {
        return afiliacionSindical;
    }

    public void setAfiliacionSindical(Boolean afiliacionSindical) {
        this.afiliacionSindical = afiliacionSindical;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public Integer getOrientacionAlimentaria() {
        return orientacionAlimentaria;
    }

    public void setOrientacionAlimentaria(Integer orientacionAlimentaria) {
        this.orientacionAlimentaria = orientacionAlimentaria;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Integer getCcaa() {
        return ccaa;
    }

    public void setCcaa(Integer ccaa) {
        this.ccaa = ccaa;
    }

    public Boolean getGuarderia() {
        return guarderia;
    }

    public void setGuarderia(Boolean guarderia) {
        this.guarderia = guarderia;
    }

    public Integer getEdadNinio() {
        return edadNinio;
    }

    public void setEdadNinio(Integer edadNinio) {
        this.edadNinio = edadNinio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public Short getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Short importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(String importePagado) {
        this.importePagado = importePagado;
    }

    public Short getVerificado() {
        return verificado;
    }

    public void setVerificado(Short verificado) {
        this.verificado = verificado;
    }

    public Boolean getNodni() {
        return nodni;
    }

    public void setNodni(Boolean nodni) {
        this.nodni = nodni;
    }

    public String getDniTutor() {
        return dniTutor;
    }

    public void setDniTutor(String dniTutor) {
        this.dniTutor = dniTutor;
    }

    public Integer getNTienda() {
        return nTienda;
    }

    public void setNTienda(Integer nTienda) {
        this.nTienda = nTienda;
    }

    public String getObservacionesOrganizacion() {
        return observacionesOrganizacion;
    }

    public void setObservacionesOrganizacion(String observacionesOrganizacion) {
        this.observacionesOrganizacion = observacionesOrganizacion;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Boolean getColabora() {
        return colabora;
    }

    public void setColabora(Boolean colabora) {
        this.colabora = colabora;
    }

    public Boolean getMediapension() {
        return mediapension;
    }

    public void setMediapension(Boolean mediapension) {
        this.mediapension = mediapension;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Short getColaboraLudoteca() {
        return colaboraLudoteca;
    }

    public void setColaboraLudoteca(Short colaboraLudoteca) {
        this.colaboraLudoteca = colaboraLudoteca;
    }

    public String getDatosLudoteca() {
        return datosLudoteca;
    }

    public void setDatosLudoteca(String datosLudoteca) {
        this.datosLudoteca = datosLudoteca;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Boolean getAlergiasBoolean() {
        return alergiasBoolean;
    }

    public void setAlergiasBoolean(Boolean alergiasBoolean) {
        this.alergiasBoolean = alergiasBoolean;
    }

    public Boolean getLanzadera() {
        return lanzadera;
    }

    public void setLanzadera(Boolean lanzadera) {
        this.lanzadera = lanzadera;
    }

    public Short getVacunacion() {
        return vacunacion;
    }

    public void setVacunacion(Short vacunacion) {
        this.vacunacion = vacunacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscripcion != null ? idInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripciones)) {
            return false;
        }
        Inscripciones other = (Inscripciones) object;
        if ((this.idInscripcion == null && other.idInscripcion != null) || (this.idInscripcion != null && !this.idInscripcion.equals(other.idInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inscripciones[ idInscripcion=" + idInscripcion + " ]";
    }

   
    
}
