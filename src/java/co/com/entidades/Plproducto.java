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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jj
 */
@Entity
@Table(name = "PLPRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plproducto.findAll", query = "SELECT p FROM Plproducto p"),
    @NamedQuery(name = "Plproducto.findByIdProducto", query = "SELECT p FROM Plproducto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Plproducto.findByNombre", query = "SELECT p FROM Plproducto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plproducto.findByDescripcion", query = "SELECT p FROM Plproducto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Plproducto.findByPrecio", query = "SELECT p FROM Plproducto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Plproducto.findByFechaVencimiento", query = "SELECT p FROM Plproducto p WHERE p.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Plproducto.findByCodigo", query = "SELECT p FROM Plproducto p WHERE p.codigo = :codigo")})
public class Plproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="PLPRODUCTO2_SEQ", sequenceName="PLPRODUCTO2_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="PLPRODUCTO2_SEQ")
    @Basic(optional = false)
    @NotNull
 
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Size(max = 200)
    @Column(name = "CODIGO")
    private String codigo;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria idCategoria;

    public Plproducto() {
    }

    public Plproducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plproducto)) {
            return false;
        }
        Plproducto other = (Plproducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.entidades.Plproducto[ idProducto=" + idProducto + " ]";
    }
    
}
