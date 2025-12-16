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

/**
 *
 * @author dioni
 */
@Entity (name="TbCcaa")
@Table(name = "tb_ccaa")
@NamedQueries({
    @NamedQuery(name = "TbCcaa.findAll", query = "SELECT t FROM TbCcaa t"),
    @NamedQuery(name = "TbCcaa.findByIdCcaa", query = "SELECT t FROM TbCcaa t WHERE t.idCcaa = :idCcaa"),
    @NamedQuery(name = "TbCcaa.findByDescCcaa", query = "SELECT t FROM TbCcaa t WHERE t.descCcaa = :descCcaa")})
public class TbCcaa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ccaa")
    private Integer idCcaa;
    @Basic(optional = false)
    @Column(name = "desc_ccaa")
    private String descCcaa;

    public TbCcaa() {
    }

    public TbCcaa(Integer idCcaa) {
        this.idCcaa = idCcaa;
    }

    public TbCcaa(Integer idCcaa, String descCcaa) {
        this.idCcaa = idCcaa;
        this.descCcaa = descCcaa;
    }

    public Integer getIdCcaa() {
        return idCcaa;
    }

    public void setIdCcaa(Integer idCcaa) {
        this.idCcaa = idCcaa;
    }

    public String getDescCcaa() {
        return descCcaa;
    }

    public void setDescCcaa(String descCcaa) {
        this.descCcaa = descCcaa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCcaa != null ? idCcaa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCcaa)) {
            return false;
        }
        TbCcaa other = (TbCcaa) object;
        if ((this.idCcaa == null && other.idCcaa != null) || (this.idCcaa != null && !this.idCcaa.equals(other.idCcaa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TbCcaa[ idCcaa=" + idCcaa + " ]";
    }
    
}
