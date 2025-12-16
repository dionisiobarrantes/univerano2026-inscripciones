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
@Table(name = "tb_ocupacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOcupacion.findAll", query = "SELECT t FROM TbOcupacion t"),
    @NamedQuery(name = "TbOcupacion.findByIdOcupacion", query = "SELECT t FROM TbOcupacion t WHERE t.idOcupacion = :idOcupacion"),
    @NamedQuery(name = "TbOcupacion.findByDescOcupacion", query = "SELECT t FROM TbOcupacion t WHERE t.descOcupacion = :descOcupacion")})
public class TbOcupacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ocupacion")
    private Integer idOcupacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "desc_ocupacion")
    private String descOcupacion;

    public TbOcupacion() {
    }

    public TbOcupacion(Integer idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public TbOcupacion(Integer idOcupacion, String descOcupacion) {
        this.idOcupacion = idOcupacion;
        this.descOcupacion = descOcupacion;
    }

    public Integer getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(Integer idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public String getDescOcupacion() {
        return descOcupacion;
    }

    public void setDescOcupacion(String descOcupacion) {
        this.descOcupacion = descOcupacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcupacion != null ? idOcupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOcupacion)) {
            return false;
        }
        TbOcupacion other = (TbOcupacion) object;
        if ((this.idOcupacion == null && other.idOcupacion != null) || (this.idOcupacion != null && !this.idOcupacion.equals(other.idOcupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbOcupacion[ idOcupacion=" + idOcupacion + " ]";
    }
    
}
