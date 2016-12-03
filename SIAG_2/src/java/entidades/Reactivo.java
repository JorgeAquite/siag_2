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
@Table(name = "REACTIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reactivo.findAll", query = "SELECT r FROM Reactivo r"),
    @NamedQuery(name = "Reactivo.findByIdreactivo", query = "SELECT r FROM Reactivo r WHERE r.idreactivo = :idreactivo"),
    @NamedQuery(name = "Reactivo.findByCodiceberg", query = "SELECT r FROM Reactivo r WHERE r.codiceberg = :codiceberg"),
    @NamedQuery(name = "Reactivo.findByReactivo", query = "SELECT r FROM Reactivo r WHERE r.reactivo = :reactivo"),
    @NamedQuery(name = "Reactivo.findByCantidadinv", query = "SELECT r FROM Reactivo r WHERE r.cantidadinv = :cantidadinv")})
public class Reactivo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREACTIVO")
    private BigDecimal idreactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CODICEBERG")
    private String codiceberg;
    @Size(max = 256)
    @Column(name = "REACTIVO")
    private String reactivo;
    @Column(name = "CANTIDADINV")
    private BigInteger cantidadinv;
    @JoinTable(name = "REACTIVO_RESERVA", joinColumns = {
        @JoinColumn(name = "IDREACTIVO", referencedColumnName = "IDREACTIVO")}, inverseJoinColumns = {
        @JoinColumn(name = "IDRESINSUMO", referencedColumnName = "IDRESINSUMO")})
    @ManyToMany
    private Collection<ReservaInsumo> reservaInsumoCollection;

    public Reactivo() {
    }

    public Reactivo(BigDecimal idreactivo) {
        this.idreactivo = idreactivo;
    }

    public Reactivo(BigDecimal idreactivo, String codiceberg) {
        this.idreactivo = idreactivo;
        this.codiceberg = codiceberg;
    }

    public BigDecimal getIdreactivo() {
        return idreactivo;
    }

    public void setIdreactivo(BigDecimal idreactivo) {
        this.idreactivo = idreactivo;
    }

    public String getCodiceberg() {
        return codiceberg;
    }

    public void setCodiceberg(String codiceberg) {
        this.codiceberg = codiceberg;
    }

    public String getReactivo() {
        return reactivo;
    }

    public void setReactivo(String reactivo) {
        this.reactivo = reactivo;
    }

    public BigInteger getCantidadinv() {
        return cantidadinv;
    }

    public void setCantidadinv(BigInteger cantidadinv) {
        this.cantidadinv = cantidadinv;
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
        hash += (idreactivo != null ? idreactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reactivo)) {
            return false;
        }
        Reactivo other = (Reactivo) object;
        if ((this.idreactivo == null && other.idreactivo != null) || (this.idreactivo != null && !this.idreactivo.equals(other.idreactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reactivo[ idreactivo=" + idreactivo + " ]";
    }
    
}
