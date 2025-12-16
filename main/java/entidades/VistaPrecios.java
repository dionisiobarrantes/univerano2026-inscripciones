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
import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dioni
 */
@Entity
@Table(name = "vista_precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaPrecios.findAll", query = "SELECT v FROM VistaPrecios v"),
    @NamedQuery(name = "VistaPrecios.findByIdPrecio", query = "SELECT v FROM VistaPrecios v WHERE v.idPrecio = :idPrecio"),
    @NamedQuery(name = "VistaPrecios.findByDescModalidadEstancia", query = "SELECT v FROM VistaPrecios v WHERE v.descModalidadEstancia = :descModalidadEstancia"),
    @NamedQuery(name = "VistaPrecios.findByDescTarifa", query = "SELECT v FROM VistaPrecios v WHERE v.descTarifa = :descTarifa"),
    @NamedQuery(name = "VistaPrecios.findByPrecio", query = "SELECT v FROM VistaPrecios v WHERE v.precio = :precio"),
    @NamedQuery(name = "VistaPrecios.findByAntes1Despues", query = "SELECT v FROM VistaPrecios v WHERE v.antes1Despues = :antes1Despues")})
public class VistaPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @NotNull
    @Column(name = "id_precio")
    private short idPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_modalidad_estancia")
    private String descModalidadEstancia;
    @Size(max = 40)
    @Column(name = "desc_tarifa")
    private String descTarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private short precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "0 antes 1 despues")
    private short antes1Despues;

    public VistaPrecios() {
    }

    public short getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(short idPrecio) {
        this.idPrecio = idPrecio;
    }

    public String getDescModalidadEstancia() {
        return descModalidadEstancia;
    }

    public void setDescModalidadEstancia(String descModalidadEstancia) {
        this.descModalidadEstancia = descModalidadEstancia;
    }

    public String getDescTarifa() {
        return descTarifa;
    }

    public void setDescTarifa(String descTarifa) {
        this.descTarifa = descTarifa;
    }

    public short getPrecio() {
        return precio;
    }

    public void setPrecio(short precio) {
        this.precio = precio;
    }

    public short getAntes1Despues() {
        return antes1Despues;
    }

    public void setAntes1Despues(short antes1Despues) {
        this.antes1Despues = antes1Despues;
    }
    
}
