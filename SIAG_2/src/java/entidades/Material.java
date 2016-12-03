/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluca
 */
@Entity
@Table(name = "MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdmaterial", query = "SELECT m FROM Material m WHERE m.idmaterial = :idmaterial"),
    @NamedQuery(name = "Material.findByMaterial", query = "SELECT m FROM Material m WHERE m.material = :material"),
    @NamedQuery(name = "Material.findByCantidad", query = "SELECT m FROM Material m WHERE m.cantidad = :cantidad")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMATERIAL")
    private BigDecimal idmaterial;
    @Size(max = 256)
    @Column(name = "MATERIAL")
    private String material;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinTable(name = "MATERIAL_RESERVA", joinColumns = {
        @JoinColumn(name = "IDMATERIAL", referencedColumnName = "IDMATERIAL")}, inverseJoinColumns = {
        @JoinColumn(name = "IDRESINSUMO", referencedColumnName = "IDRESINSUMO")})
    @ManyToMany
    private Collection<ReservaInsumo> reservaInsumoCollection;

    public Material() {
    }

    public Material(BigDecimal idmaterial) {
        this.idmaterial = idmaterial;
    }

    public BigDecimal getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(BigDecimal idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<ReservaInsumo> getReservaInsumoCollection() {
        return reservaInsumoCollection;
    }

    public void setReservaInsumoCollection(Collection<ReservaInsumo> reservaInsumoCollection) {
        this.reservaInsumoCollection = reservaInsumoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterial != null ? idmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idmaterial == null && other.idmaterial != null) || (this.idmaterial != null && !this.idmaterial.equals(other.idmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Material[ idmaterial=" + idmaterial + " ]";
    }
    
}
