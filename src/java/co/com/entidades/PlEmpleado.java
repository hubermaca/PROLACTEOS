/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author porta
 */
@Entity
@Table(name = "PL_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlEmpleado.findAll", query = "SELECT p FROM PlEmpleado p"),
    @NamedQuery(name = "PlEmpleado.findByIdEmpleado", query = "SELECT p FROM PlEmpleado p WHERE p.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "PlEmpleado.findByIdentificacion", query = "SELECT p FROM PlEmpleado p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "PlEmpleado.findByNombres", query = "SELECT p FROM PlEmpleado p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "PlEmpleado.findByApellido1", query = "SELECT p FROM PlEmpleado p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "PlEmpleado.findByApellido2", query = "SELECT p FROM PlEmpleado p WHERE p.apellido2 = :apellido2"),
    @NamedQuery(name = "PlEmpleado.findByGenero", query = "SELECT p FROM PlEmpleado p WHERE p.genero = :genero"),
    @NamedQuery(name = "PlEmpleado.findByFechaNacimiento", query = "SELECT p FROM PlEmpleado p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "PlEmpleado.findByCorreo", query = "SELECT p FROM PlEmpleado p WHERE p.correo = :correo"),
    @NamedQuery(name = "PlEmpleado.findByTelefono", query = "SELECT p FROM PlEmpleado p WHERE p.telefono = :telefono")})
public class PlEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;
    @Size(max = 99)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Size(max = 200)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 200)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 200)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 100)
    @Column(name = "TELEFONO")
    private String telefono;

    public PlEmpleado() {
    }

    public PlEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlEmpleado)) {
            return false;
        }
        PlEmpleado other = (PlEmpleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.entidades.PlEmpleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
