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
@Table(name = "tb_camas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCamas.findAll", query = "SELECT t FROM TbCamas t"),
    @NamedQuery(name = "TbCamas.findByIdCama", query = "SELECT t FROM TbCamas t WHERE t.idCama = :idCama"),
    @NamedQuery(name = "TbCamas.findByIdTipoHabitacion", query = "SELECT t FROM TbCamas t WHERE t.idTipoHabitacion = :idTipoHabitacion"),
    @NamedQuery(name = "TbCamas.findByNumCama", query = "SELECT t FROM TbCamas t WHERE t.numCama = :numCama"),
    @NamedQuery(name = "TbCamas.findByNumHabitacion", query = "SELECT t FROM TbCamas t WHERE t.numHabitacion = :numHabitacion"),
    @NamedQuery(name = "TbCamas.findByNumMatricula", query = "SELECT t FROM TbCamas t WHERE t.numMatricula = :numMatricula"),
    @NamedQuery(name = "TbCamas.findByO1", query = "SELECT t FROM TbCamas t WHERE t.o1 = :o1"),
    @NamedQuery(name = "TbCamas.findByO1NumMatricula", query = "SELECT t FROM TbCamas t WHERE t.o1NumMatricula = :o1NumMatricula"),
    @NamedQuery(name = "TbCamas.findByO2", query = "SELECT t FROM TbCamas t WHERE t.o2 = :o2"),
    @NamedQuery(name = "TbCamas.findByO2NumMatricula", query = "SELECT t FROM TbCamas t WHERE t.o2NumMatricula = :o2NumMatricula"),
    @NamedQuery(name = "TbCamas.findByO3", query = "SELECT t FROM TbCamas t WHERE t.o3 = :o3"),
    @NamedQuery(name = "TbCamas.findByO3NumMatricula", query = "SELECT t FROM TbCamas t WHERE t.o3NumMatricula = :o3NumMatricula"),
    @NamedQuery(name = "TbCamas.findByO4", query = "SELECT t FROM TbCamas t WHERE t.o4 = :o4"),
    @NamedQuery(name = "TbCamas.findByO4NumMatricula", query = "SELECT t FROM TbCamas t WHERE t.o4NumMatricula = :o4NumMatricula"),
    @NamedQuery(name = "TbCamas.findByO5", query = "SELECT t FROM TbCamas t WHERE t.o5 = :o5"),
    @NamedQuery(name = "TbCamas.findByO5NumMatricula", query = "SELECT t FROM TbCamas t WHERE t.o5NumMatricula = :o5NumMatricula"),
    @NamedQuery(name = "TbCamas.findByCompleto", query = "SELECT t FROM TbCamas t WHERE t.completo = :completo"),
    @NamedQuery(name = "TbCamas.findByObservaciones", query = "SELECT t FROM TbCamas t WHERE t.observaciones = :observaciones")})
public class TbCamas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cama")
    private Integer idCama;
    @Column(name = "id_tipo_habitacion")
    private Short idTipoHabitacion;
    @Column(name = "num_cama")
    private Short numCama;
    @Column(name = "num_habitacion")
    private Short numHabitacion;
    @Column(name = "num_matricula")
    private Short numMatricula;
    @Column(name = "o1")
    private Boolean o1;
    @Column(name = "o1_num_matricula")
    private Short o1NumMatricula;
    @Column(name = "o2")
    private Boolean o2;
    @Column(name = "o2_num_matricula")
    private Short o2NumMatricula;
    @Column(name = "o3")
    private Boolean o3;
    @Column(name = "o3_num_matricula")
    private Short o3NumMatricula;
    @Column(name = "o4")
    private Boolean o4;
    @Column(name = "o4_num_matricula")
    private Short o4NumMatricula;
    @Column(name = "o5")
    private Boolean o5;
    @Column(name = "o5_num_matricula")
    private Short o5NumMatricula;
    @Column(name = "completo")
    private Boolean completo;
    @Size(max = 40)
    @Column(name = "observaciones")
    private String observaciones;

    public TbCamas() {
    }

    public TbCamas(Integer idCama) {
        this.idCama = idCama;
    }

    public Integer getIdCama() {
        return idCama;
    }

    public void setIdCama(Integer idCama) {
        this.idCama = idCama;
    }

    public Short getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(Short idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public Short getNumCama() {
        return numCama;
    }

    public void setNumCama(Short numCama) {
        this.numCama = numCama;
    }

    public Short getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(Short numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Short getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(Short numMatricula) {
        this.numMatricula = numMatricula;
    }

    public Boolean getO1() {
        return o1;
    }

    public void setO1(Boolean o1) {
        this.o1 = o1;
    }

    public Short getO1NumMatricula() {
        return o1NumMatricula;
    }

    public void setO1NumMatricula(Short o1NumMatricula) {
        this.o1NumMatricula = o1NumMatricula;
    }

    public Boolean getO2() {
        return o2;
    }

    public void setO2(Boolean o2) {
        this.o2 = o2;
    }

    public Short getO2NumMatricula() {
        return o2NumMatricula;
    }

    public void setO2NumMatricula(Short o2NumMatricula) {
        this.o2NumMatricula = o2NumMatricula;
    }

    public Boolean getO3() {
        return o3;
    }

    public void setO3(Boolean o3) {
        this.o3 = o3;
    }

    public Short getO3NumMatricula() {
        return o3NumMatricula;
    }

    public void setO3NumMatricula(Short o3NumMatricula) {
        this.o3NumMatricula = o3NumMatricula;
    }

    public Boolean getO4() {
        return o4;
    }

    public void setO4(Boolean o4) {
        this.o4 = o4;
    }

    public Short getO4NumMatricula() {
        return o4NumMatricula;
    }

    public void setO4NumMatricula(Short o4NumMatricula) {
        this.o4NumMatricula = o4NumMatricula;
    }

    public Boolean getO5() {
        return o5;
    }

    public void setO5(Boolean o5) {
        this.o5 = o5;
    }

    public Short getO5NumMatricula() {
        return o5NumMatricula;
    }

    public void setO5NumMatricula(Short o5NumMatricula) {
        this.o5NumMatricula = o5NumMatricula;
    }

    public Boolean getCompleto() {
        return completo;
    }

    public void setCompleto(Boolean completo) {
        this.completo = completo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCama != null ? idCama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCamas)) {
            return false;
        }
        TbCamas other = (TbCamas) object;
        if ((this.idCama == null && other.idCama != null) || (this.idCama != null && !this.idCama.equals(other.idCama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbCamas[ idCama=" + idCama + " ]";
    }
    
}
