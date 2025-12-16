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
import jakarta.persistence.Lob;
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
@Table(name = "preinscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preinscripcion.findAll", query = "SELECT p FROM Preinscripcion p"),
    @NamedQuery(name = "Preinscripcion.findById", query = "SELECT p FROM Preinscripcion p WHERE p.id = :id"),
    @NamedQuery(name = "Preinscripcion.findByEdad", query = "SELECT p FROM Preinscripcion p WHERE p.edad = :edad"),
    @NamedQuery(name = "Preinscripcion.findByImporte", query = "SELECT p FROM Preinscripcion p WHERE p.importe = :importe"),
    @NamedQuery(name = "Preinscripcion.findByMovil", query = "SELECT p FROM Preinscripcion p WHERE p.movil = :movil")})
public class Preinscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "Submitted")
    private String submitted;
    @Lob
    @Size(max = 65535)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "dni")
    private String dni;
    @Lob
    @Size(max = 65535)
    @Column(name = "fechanacimiento")
    private String fechanacimiento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Lob
    @Size(max = 65535)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 65535)
    @Column(name = "comautonoma")
    private String comautonoma;
    @Lob
    @Size(max = 65535)
    @Column(name = "organizacion")
    private String organizacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "otraorganizacion")
    private String otraorganizacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "otraocupacion")
    private String otraocupacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "estancia")
    private String estancia;
    @Lob
    @Size(max = 65535)
    @Column(name = "tarifa")
    private String tarifa;
    @Lob
    @Size(max = 65535)
    @Column(name = "dieta")
    private String dieta;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionalergias")
    private String descripcionalergias;
    @Lob
    @Size(max = 65535)
    @Column(name = "dnitutor")
    private String dnitutor;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentarios")
    private String comentarios;
    @Lob
    @Size(max = 65535)
    @Column(name = "conforme")
    private String conforme;
    @Lob
    @Size(max = 65535)
    @Column(name = "alergias")
    private String alergias;
    @Lob
    @Size(max = 65535)
    @Column(name = "lanzadera")
    private String lanzadera;
    @Lob
    @Size(max = 65535)
    @Column(name = "ludoteca")
    private String ludoteca;
    @Lob
    @Size(max = 65535)
    @Column(name = "colaborar")
    private String colaborar;
    @Lob
    @Size(max = 65535)
    @Column(name = "Submitted Login")
    private String submittedLogin;
    @Lob
    @Size(max = 65535)
    @Column(name = "Submitted From")
    private String submittedFrom;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "importe")
    private Integer importe;
    @Size(max = 45)
    @Column(name = "movil")
    private String movil;

    public Preinscripcion() {
    }

    public Preinscripcion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComautonoma() {
        return comautonoma;
    }

    public void setComautonoma(String comautonoma) {
        this.comautonoma = comautonoma;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getOtraorganizacion() {
        return otraorganizacion;
    }

    public void setOtraorganizacion(String otraorganizacion) {
        this.otraorganizacion = otraorganizacion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getOtraocupacion() {
        return otraocupacion;
    }

    public void setOtraocupacion(String otraocupacion) {
        this.otraocupacion = otraocupacion;
    }

    public String getEstancia() {
        return estancia;
    }

    public void setEstancia(String estancia) {
        this.estancia = estancia;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getDescripcionalergias() {
        return descripcionalergias;
    }

    public void setDescripcionalergias(String descripcionalergias) {
        this.descripcionalergias = descripcionalergias;
    }

    public String getDnitutor() {
        return dnitutor;
    }

    public void setDnitutor(String dnitutor) {
        this.dnitutor = dnitutor;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getConforme() {
        return conforme;
    }

    public void setConforme(String conforme) {
        this.conforme = conforme;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getLanzadera() {
        return lanzadera;
    }

    public void setLanzadera(String lanzadera) {
        this.lanzadera = lanzadera;
    }

    public String getLudoteca() {
        return ludoteca;
    }

    public void setLudoteca(String ludoteca) {
        this.ludoteca = ludoteca;
    }

    public String getColaborar() {
        return colaborar;
    }

    public void setColaborar(String colaborar) {
        this.colaborar = colaborar;
    }

    public String getSubmittedLogin() {
        return submittedLogin;
    }

    public void setSubmittedLogin(String submittedLogin) {
        this.submittedLogin = submittedLogin;
    }

    public String getSubmittedFrom() {
        return submittedFrom;
    }

    public void setSubmittedFrom(String submittedFrom) {
        this.submittedFrom = submittedFrom;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preinscripcion)) {
            return false;
        }
        Preinscripcion other = (Preinscripcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Preinscripcion[ id=" + id + " ]";
    }
    
}
