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
import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dioni
 */
@Entity
@Table(name = "tb_precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPrecios.findAll", query = "SELECT t FROM TbPrecios t"),
    @NamedQuery(name = "TbPrecios.findByIdModalidad", query = "SELECT t FROM TbPrecios t WHERE t.idModalidad = :idModalidad"),
    @NamedQuery(name = "TbPrecios.findByIdTarifa", query = "SELECT t FROM TbPrecios t WHERE t.idTarifa = :idTarifa"),
    @NamedQuery(name = "TbPrecios.findByPrecio", query = "SELECT t FROM TbPrecios t WHERE t.precio = :precio"),
    @NamedQuery(name = "TbPrecios.findByIdPrecio", query = "SELECT t FROM TbPrecios t WHERE t.idPrecio = :idPrecio"),
    @NamedQuery(name = "TbPrecios.findByIdAntesDespues", query = "SELECT t FROM TbPrecios t WHERE t.idAntesDespues = :idAntesDespues")})
public class TbPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modalidad")
    private short idModalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarifa")
    private short idTarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private short precio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_precio")
    private Short idPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_antes_despues")
    private short idAntesDespues;

    public TbPrecios() {
    }

    public TbPrecios(Short idPrecio) {
        this.idPrecio = idPrecio;
    }

    public TbPrecios(Short idPrecio, short idModalidad, short idTarifa, short precio, short idAntesDespues) {
        this.idPrecio = idPrecio;
        this.idModalidad = idModalidad;
        this.idTarifa = idTarifa;
        this.precio = precio;
        this.idAntesDespues = idAntesDespues;
    }

    public short getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(short idModalidad) {
        this.idModalidad = idModalidad;
    }

    public short getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(short idTarifa) {
        this.idTarifa = idTarifa;
    }

    public short getPrecio() {
        return precio;
    }

    public void setPrecio(short precio) {
        this.precio = precio;
    }

    public Short getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Short idPrecio) {
        this.idPrecio = idPrecio;
    }

    public short getIdAntesDespues() {
        return idAntesDespues;
    }

    public void setIdAntesDespues(short idAntesDespues) {
        this.idAntesDespues = idAntesDespues;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPrecios)) {
            return false;
        }
        TbPrecios other = (TbPrecios) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbPrecios[ idPrecio=" + idPrecio + " ]";
    }
    
}
