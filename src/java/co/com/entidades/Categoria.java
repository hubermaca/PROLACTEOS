/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jj
 */
@Entity
@Table(name = "PLCATEGORIA")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Plcategoria.findAll", query = "SELECT p FROM Plcategoria p"),
//    @NamedQuery(name = "Plcategoria.findByIdCategoria", query = "SELECT p FROM Plcategoria p WHERE p.idCategoria = :idCategoria"),
//    @NamedQuery(name = "Plcategoria.findByCodigoCategoria", query = "SELECT p FROM Plcategoria p WHERE p.codigoCategoria = :codigoCategoria"),
//    @NamedQuery(name = "Plcategoria.findByNombre", query = "SELECT p FROM Plcategoria p WHERE p.nombre = :nombre"),
//    @NamedQuery(name = "Plcategoria.findByDescripcion", query = "SELECT p FROM Plcategoria p WHERE p.descripcion = :descripcion")})
    public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @SequenceGenerator(name = "categoria_seq",sequenceName="categoria_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoria_seq")
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CATEGORIA")
    private BigDecimal idCategoria;
    @Size(max = 200)
    @Column(name = "CODIGO_CATEGORIA")
    private String codigoCategoria;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idCategoria")
    private List<Plproducto> plproductoList;

    public Categoria() {
    }

    public Categoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(BigDecimal idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    @XmlTransient
    public List<Plproducto> getPlproductoList() {
        return plproductoList;
    }

    public void setPlproductoList(List<Plproducto> plproductoList) {
        this.plproductoList = plproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.entidades.Plcategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
