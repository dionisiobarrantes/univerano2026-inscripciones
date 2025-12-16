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
@Table(name = "tb_modalidad_estancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbModalidadEstancia.findAll", query = "SELECT t FROM TbModalidadEstancia t"),
    @NamedQuery(name = "TbModalidadEstancia.findByDescModalidadEstancia", query = "SELECT t FROM TbModalidadEstancia t WHERE t.descModalidadEstancia = :descModalidadEstancia"),
    @NamedQuery(name = "TbModalidadEstancia.findByIdModalidadEstancia", query = "SELECT t FROM TbModalidadEstancia t WHERE t.idModalidadEstancia = :idModalidadEstancia"),
    @NamedQuery(name = "TbModalidadEstancia.findByVisible", query = "SELECT t FROM TbModalidadEstancia t WHERE t.visible = :visible")})
public class TbModalidadEstancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_modalidad_estancia")
    private String descModalidadEstancia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modalidad_estancia")
    private Integer idModalidadEstancia;
    @Column(name = "visible")
    private Short visible;

    public TbModalidadEstancia() {
    }

    public TbModalidadEstancia(Integer idModalidadEstancia) {
        this.idModalidadEstancia = idModalidadEstancia;
    }

    public TbModalidadEstancia(Integer idModalidadEstancia, String descModalidadEstancia) {
        this.idModalidadEstancia = idModalidadEstancia;
        this.descModalidadEstancia = descModalidadEstancia;
    }

    public String getDescModalidadEstancia() {
        return descModalidadEstancia;
    }

    public void setDescModalidadEstancia(String descModalidadEstancia) {
        this.descModalidadEstancia = descModalidadEstancia;
    }

    public Integer getIdModalidadEstancia() {
        return idModalidadEstancia;
    }

    public void setIdModalidadEstancia(Integer idModalidadEstancia) {
        this.idModalidadEstancia = idModalidadEstancia;
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
        hash += (idModalidadEstancia != null ? idModalidadEstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbModalidadEstancia)) {
            return false;
        }
        TbModalidadEstancia other = (TbModalidadEstancia) object;
        if ((this.idModalidadEstancia == null && other.idModalidadEstancia != null) || (this.idModalidadEstancia != null && !this.idModalidadEstancia.equals(other.idModalidadEstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbModalidadEstancia[ idModalidadEstancia=" + idModalidadEstancia + " ]";
    }
    
}
