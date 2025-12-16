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
@Table(name = "tb_organizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrganizacion.findAll", query = "SELECT t FROM TbOrganizacion t"),
    @NamedQuery(name = "TbOrganizacion.findByIdOrganizacion", query = "SELECT t FROM TbOrganizacion t WHERE t.idOrganizacion = :idOrganizacion"),
    @NamedQuery(name = "TbOrganizacion.findByDescOrganizacion", query = "SELECT t FROM TbOrganizacion t WHERE t.descOrganizacion = :descOrganizacion")})
public class TbOrganizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_organizacion")
    private Integer idOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "desc_organizacion")
    private String descOrganizacion;

    public TbOrganizacion() {
    }

    public TbOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public TbOrganizacion(Integer idOrganizacion, String descOrganizacion) {
        this.idOrganizacion = idOrganizacion;
        this.descOrganizacion = descOrganizacion;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getDescOrganizacion() {
        return descOrganizacion;
    }

    public void setDescOrganizacion(String descOrganizacion) {
        this.descOrganizacion = descOrganizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganizacion != null ? idOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOrganizacion)) {
            return false;
        }
        TbOrganizacion other = (TbOrganizacion) object;
        if ((this.idOrganizacion == null && other.idOrganizacion != null) || (this.idOrganizacion != null && !this.idOrganizacion.equals(other.idOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbOrganizacion[ idOrganizacion=" + idOrganizacion + " ]";
    }
    
}
