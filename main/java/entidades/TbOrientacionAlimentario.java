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
@Table(name = "tb_orientacion_alimentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrientacionAlimentario.findAll", query = "SELECT t FROM TbOrientacionAlimentario t"),
    @NamedQuery(name = "TbOrientacionAlimentario.findByIdOrientacionAlimentaria", query = "SELECT t FROM TbOrientacionAlimentario t WHERE t.idOrientacionAlimentaria = :idOrientacionAlimentaria"),
    @NamedQuery(name = "TbOrientacionAlimentario.findByDescOrientacionAlimentaria", query = "SELECT t FROM TbOrientacionAlimentario t WHERE t.descOrientacionAlimentaria = :descOrientacionAlimentaria")})
public class TbOrientacionAlimentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orientacion_alimentaria")
    private Integer idOrientacionAlimentaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "desc_orientacion_alimentaria")
    private String descOrientacionAlimentaria;

    public TbOrientacionAlimentario() {
    }

    public TbOrientacionAlimentario(Integer idOrientacionAlimentaria) {
        this.idOrientacionAlimentaria = idOrientacionAlimentaria;
    }

    public TbOrientacionAlimentario(Integer idOrientacionAlimentaria, String descOrientacionAlimentaria) {
        this.idOrientacionAlimentaria = idOrientacionAlimentaria;
        this.descOrientacionAlimentaria = descOrientacionAlimentaria;
    }

    public Integer getIdOrientacionAlimentaria() {
        return idOrientacionAlimentaria;
    }

    public void setIdOrientacionAlimentaria(Integer idOrientacionAlimentaria) {
        this.idOrientacionAlimentaria = idOrientacionAlimentaria;
    }

    public String getDescOrientacionAlimentaria() {
        return descOrientacionAlimentaria;
    }

    public void setDescOrientacionAlimentaria(String descOrientacionAlimentaria) {
        this.descOrientacionAlimentaria = descOrientacionAlimentaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrientacionAlimentaria != null ? idOrientacionAlimentaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOrientacionAlimentario)) {
            return false;
        }
        TbOrientacionAlimentario other = (TbOrientacionAlimentario) object;
        if ((this.idOrientacionAlimentaria == null && other.idOrientacionAlimentaria != null) || (this.idOrientacionAlimentaria != null && !this.idOrientacionAlimentaria.equals(other.idOrientacionAlimentaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbOrientacionAlimentario[ idOrientacionAlimentaria=" + idOrientacionAlimentaria + " ]";
    }
    
}
