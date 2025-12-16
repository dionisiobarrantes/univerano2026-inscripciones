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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dioni
 */
@Entity
@Table(name = "tb_tipo_habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoHabitacion.findAll", query = "SELECT t FROM TbTipoHabitacion t"),
    @NamedQuery(name = "TbTipoHabitacion.findByIdTipoHabitacion", query = "SELECT t FROM TbTipoHabitacion t WHERE t.idTipoHabitacion = :idTipoHabitacion"),
    @NamedQuery(name = "TbTipoHabitacion.findByDescTipoHabitacion", query = "SELECT t FROM TbTipoHabitacion t WHERE t.descTipoHabitacion = :descTipoHabitacion")})
public class TbTipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion;
    @Size(max = 255)
    @Column(name = "desc_tipo_habitacion")
    private String descTipoHabitacion;

    public TbTipoHabitacion() {
    }

    public TbTipoHabitacion(Integer idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public Integer getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(Integer idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getDescTipoHabitacion() {
        return descTipoHabitacion;
    }

    public void setDescTipoHabitacion(String descTipoHabitacion) {
        this.descTipoHabitacion = descTipoHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoHabitacion != null ? idTipoHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoHabitacion)) {
            return false;
        }
        TbTipoHabitacion other = (TbTipoHabitacion) object;
        if ((this.idTipoHabitacion == null && other.idTipoHabitacion != null) || (this.idTipoHabitacion != null && !this.idTipoHabitacion.equals(other.idTipoHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbTipoHabitacion[ idTipoHabitacion=" + idTipoHabitacion + " ]";
    }
    
}
