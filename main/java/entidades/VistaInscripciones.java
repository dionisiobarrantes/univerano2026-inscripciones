/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "vista_inscripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaInscripciones.findAll", query = "SELECT v FROM VistaInscripciones v"),
    @NamedQuery(name = "VistaInscripciones.findByIdInscripcion", query = "SELECT v FROM VistaInscripciones v WHERE v.idInscripcion = :idInscripcion"),
    @NamedQuery(name = "VistaInscripciones.findByNombreApellidos", query = "SELECT v FROM VistaInscripciones v WHERE v.nombreApellidos = :nombreApellidos"),
    @NamedQuery(name = "VistaInscripciones.findByFechaInscripcion", query = "SELECT v FROM VistaInscripciones v WHERE v.fechaInscripcion = :fechaInscripcion"),
    @NamedQuery(name = "VistaInscripciones.findByDuracionEstancia", query = "SELECT v FROM VistaInscripciones v WHERE v.duracionEstancia = :duracionEstancia"),
    @NamedQuery(name = "VistaInscripciones.findByEdad", query = "SELECT v FROM VistaInscripciones v WHERE v.edad = :edad"),
    @NamedQuery(name = "VistaInscripciones.findByDniNie", query = "SELECT v FROM VistaInscripciones v WHERE v.dniNie = :dniNie"),
    @NamedQuery(name = "VistaInscripciones.findByCorreoElectronico", query = "SELECT v FROM VistaInscripciones v WHERE v.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "VistaInscripciones.findByTelefono", query = "SELECT v FROM VistaInscripciones v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "VistaInscripciones.findByOtraOcupacion", query = "SELECT v FROM VistaInscripciones v WHERE v.otraOcupacion = :otraOcupacion"),
    @NamedQuery(name = "VistaInscripciones.findByOtraOrganizacion", query = "SELECT v FROM VistaInscripciones v WHERE v.otraOrganizacion = :otraOrganizacion"),
    @NamedQuery(name = "VistaInscripciones.findByAfiliacionSindical", query = "SELECT v FROM VistaInscripciones v WHERE v.afiliacionSindical = :afiliacionSindical"),
    @NamedQuery(name = "VistaInscripciones.findBySindicato", query = "SELECT v FROM VistaInscripciones v WHERE v.sindicato = :sindicato"),
    @NamedQuery(name = "VistaInscripciones.findByCiudadResidencia", query = "SELECT v FROM VistaInscripciones v WHERE v.ciudadResidencia = :ciudadResidencia"),
    @NamedQuery(name = "VistaInscripciones.findByGuarderia", query = "SELECT v FROM VistaInscripciones v WHERE v.guarderia = :guarderia"),
    @NamedQuery(name = "VistaInscripciones.findByEdadNinio", query = "SELECT v FROM VistaInscripciones v WHERE v.edadNinio = :edadNinio"),
    @NamedQuery(name = "VistaInscripciones.findByObservaciones", query = "SELECT v FROM VistaInscripciones v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "VistaInscripciones.findByImporteTotal", query = "SELECT v FROM VistaInscripciones v WHERE v.importeTotal = :importeTotal"),
    @NamedQuery(name = "VistaInscripciones.findByImportePagado", query = "SELECT v FROM VistaInscripciones v WHERE v.importePagado = :importePagado"),
    @NamedQuery(name = "VistaInscripciones.findByFechaLlegada", query = "SELECT v FROM VistaInscripciones v WHERE v.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "VistaInscripciones.findByVerificado", query = "SELECT v FROM VistaInscripciones v WHERE v.verificado = :verificado"),
    @NamedQuery(name = "VistaInscripciones.findByCancelada", query = "SELECT v FROM VistaInscripciones v WHERE v.cancelada = :cancelada"),
    @NamedQuery(name = "VistaInscripciones.findByDescCcaa", query = "SELECT v FROM VistaInscripciones v WHERE v.descCcaa = :descCcaa"),
    @NamedQuery(name = "VistaInscripciones.findByDescModalidadEstancia", query = "SELECT v FROM VistaInscripciones v WHERE v.descModalidadEstancia = :descModalidadEstancia"),
    @NamedQuery(name = "VistaInscripciones.findByDescOcupacion", query = "SELECT v FROM VistaInscripciones v WHERE v.descOcupacion = :descOcupacion"),
    @NamedQuery(name = "VistaInscripciones.findByDescOrganizacion", query = "SELECT v FROM VistaInscripciones v WHERE v.descOrganizacion = :descOrganizacion"),
    @NamedQuery(name = "VistaInscripciones.findByDescOrientacionAlimentaria", query = "SELECT v FROM VistaInscripciones v WHERE v.descOrientacionAlimentaria = :descOrientacionAlimentaria"),
    @NamedQuery(name = "VistaInscripciones.findByDescTarifa", query = "SELECT v FROM VistaInscripciones v WHERE v.descTarifa = :descTarifa")})
public class VistaInscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Id
    @Column(name = "id_inscripcion")
    private short idInscripcion;
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
    @Size(max = 50)
    @Column(name = "otra_ocupacion")
    private String otraOcupacion;
    @Size(max = 100)
    @Column(name = "otra_organizacion")
    private String otraOrganizacion;
    @Column(name = "afiliacion_sindical")
    private Boolean afiliacionSindical;
    @Size(max = 40)
    @Column(name = "sindicato")
    private String sindicato;
    @Size(max = 60)
    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;
    @Column(name = "guarderia")
    private Short guarderia;
    @Column(name = "edad_ninio")
    private Integer edadNinio;
    @Size(max = 550)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "importe_total")
    private Short importeTotal;
    @Size(max = 10)
    @Column(name = "importe_pagado")
    private String importePagado;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Column(name = "verificado")
    private Short verificado;
    @Column(name = "cancelada")
    private Short cancelada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desc_ccaa")
    private String descCcaa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_modalidad_estancia")
    private String descModalidadEstancia;
    @Size(max = 40)
    @Column(name = "desc_ocupacion")
    private String descOcupacion;
    @Size(max = 45)
    @Column(name = "desc_organizacion")
    private String descOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "desc_orientacion_alimentaria")
    private String descOrientacionAlimentaria;
    @Size(max = 40)
    @Column(name = "desc_tarifa")
    private String descTarifa;

    public VistaInscripciones() {
    }

    public short getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(short idInscripcion) {
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

    public String getOtraOcupacion() {
        return otraOcupacion;
    }

    public void setOtraOcupacion(String otraOcupacion) {
        this.otraOcupacion = otraOcupacion;
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

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Short getGuarderia() {
        return guarderia;
    }

    public void setGuarderia(Short guarderia) {
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

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Short getVerificado() {
        return verificado;
    }

    public void setVerificado(Short verificado) {
        this.verificado = verificado;
    }

    public Short getCancelada() {
        return cancelada;
    }

    public void setCancelada(Short cancelada) {
        this.cancelada = cancelada;
    }

    public String getDescCcaa() {
        return descCcaa;
    }

    public void setDescCcaa(String descCcaa) {
        this.descCcaa = descCcaa;
    }

    public String getDescModalidadEstancia() {
        return descModalidadEstancia;
    }

    public void setDescModalidadEstancia(String descModalidadEstancia) {
        this.descModalidadEstancia = descModalidadEstancia;
    }

    public String getDescOcupacion() {
        return descOcupacion;
    }

    public void setDescOcupacion(String descOcupacion) {
        this.descOcupacion = descOcupacion;
    }

    public String getDescOrganizacion() {
        return descOrganizacion;
    }

    public void setDescOrganizacion(String descOrganizacion) {
        this.descOrganizacion = descOrganizacion;
    }

    public String getDescOrientacionAlimentaria() {
        return descOrientacionAlimentaria;
    }

    public void setDescOrientacionAlimentaria(String descOrientacionAlimentaria) {
        this.descOrientacionAlimentaria = descOrientacionAlimentaria;
    }

    public String getDescTarifa() {
        return descTarifa;
    }

    public void setDescTarifa(String descTarifa) {
        this.descTarifa = descTarifa;
    }
    
}
