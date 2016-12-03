/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluca
 */
@Entity
@Table(name = "RESERVA_INSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaInsumo.findAll", query = "SELECT r FROM ReservaInsumo r"),
    @NamedQuery(name = "ReservaInsumo.findByIdresinsumo", query = "SELECT r FROM ReservaInsumo r WHERE r.idresinsumo = :idresinsumo")})
public class ReservaInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESINSUMO")
    private BigDecimal idresinsumo;
    @ManyToMany(mappedBy = "reservaInsumoCollection")
    private Collection<Material> materialCollection;
    @ManyToMany(mappedBy = "reservaInsumoCollection")
    private Collection<Reactivo> reactivoCollection;
    @JoinColumn(name = "IDRESLABORATORIO", referencedColumnName = "IDRESLABORATORIO")
    @ManyToOne
    private ReservaLab idreslaboratorio;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;

    public ReservaInsumo() {
    }

    public ReservaInsumo(BigDecimal idresinsumo) {
        this.idresinsumo = idresinsumo;
    }

    public BigDecimal getIdresinsumo() {
        return idresinsumo;
    }

    public void setIdresinsumo(BigDecimal idresinsumo) {
        this.idresinsumo = idresinsumo;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    @XmlTransient
    public Collection<Reactivo> getReactivoCollection() {
        return reactivoCollection;
    }

    public void setReactivoCollection(Collection<Reactivo> reactivoCollection) {
        this.reactivoCollection = reactivoCollection;
    }

    public ReservaLab getIdreslaboratorio() {
        return idreslaboratorio;
    }

    public void setIdreslaboratorio(ReservaLab idreslaboratorio) {
        this.idreslaboratorio = idreslaboratorio;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresinsumo != null ? idresinsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaInsumo)) {
            return false;
        }
        ReservaInsumo other = (ReservaInsumo) object;
        if ((this.idresinsumo == null && other.idresinsumo != null) || (this.idresinsumo != null && !this.idresinsumo.equals(other.idresinsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReservaInsumo[ idresinsumo=" + idresinsumo + " ]";
    }
    
}
