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
@Table(name = "tb_tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTarifa.findAll", query = "SELECT t FROM TbTarifa t"),
    @NamedQuery(name = "TbTarifa.findByIdTarifa", query = "SELECT t FROM TbTarifa t WHERE t.idTarifa = :idTarifa"),
    @NamedQuery(name = "TbTarifa.findByDescTarifa", query = "SELECT t FROM TbTarifa t WHERE t.descTarifa = :descTarifa"),
    @NamedQuery(name = "TbTarifa.findByVisible", query = "SELECT t FROM TbTarifa t WHERE t.visible = :visible")})
public class TbTarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarifa")
    private Integer idTarifa;
    @Size(max = 40)
    @Column(name = "desc_tarifa")
    private String descTarifa;
    @Column(name = "visible")
    private Short visible;

    public TbTarifa() {
    }

    public TbTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getDescTarifa() {
        return descTarifa;
    }

    public void setDescTarifa(String descTarifa) {
        this.descTarifa = descTarifa;
    }

    public Short getVisible() {
        return visible;
    }

    public void setVisible(Short visible) {
        this.visible = visible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTarifa)) {
            return false;
        }
        TbTarifa other = (TbTarifa) object;
        if ((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbTarifa[ idTarifa=" + idTarifa + " ]";
    }
    
}
