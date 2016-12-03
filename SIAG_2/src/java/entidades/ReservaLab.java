/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluca
 */
@Entity
@Table(name = "RESERVA_LAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaLab.findAll", query = "SELECT r FROM ReservaLab r"),
    @NamedQuery(name = "ReservaLab.findByIdreslaboratorio", query = "SELECT r FROM ReservaLab r WHERE r.idreslaboratorio = :idreslaboratorio"),
    @NamedQuery(name = "ReservaLab.findByFechareserva", query = "SELECT r FROM ReservaLab r WHERE r.fechareserva = :fechareserva")})
public class ReservaLab implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESLABORATORIO")
    private BigDecimal idreslaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHARESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareserva;
    @OneToMany(mappedBy = "idreslaboratorio")
    private Collection<ReservaInsumo> reservaInsumoCollection;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO")
    @ManyToOne
    private Laboratorio idlaboratorio;
    @JoinColumn(name = "IDPRACTICA", referencedColumnName = "IDPRACTICA")
    @ManyToOne
    private Practica idpractica;

    public ReservaLab() {
    }

    public ReservaLab(BigDecimal idreslaboratorio) {
        this.idreslaboratorio = idreslaboratorio;
    }

    public ReservaLab(BigDecimal idreslaboratorio, Date fechareserva) {
        this.idreslaboratorio = idreslaboratorio;
        this.fechareserva = fechareserva;
    }

    public BigDecimal getIdreslaboratorio() {
        return idreslaboratorio;
    }

    public void setIdreslaboratorio(BigDecimal idreslaboratorio) {
        this.idreslaboratorio = idreslaboratorio;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    @XmlTransient
    public Collection<ReservaInsumo> getReservaInsumoCollection() {
        return reservaInsumoCollection;
    }

    public void setReservaInsumoCollection(Collection<ReservaInsumo> reservaInsumoCollection) {
        this.reservaInsumoCollection = reservaInsumoCollection;
    }

    public Laboratorio getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(Laboratorio idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public Practica getIdpractica() {
        return idpractica;
    }

    public void setIdpractica(Practica idpractica) {
        this.idpractica = idpractica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreslaboratorio != null ? idreslaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaLab)) {
            return false;
        }
        ReservaLab other = (ReservaLab) object;
        if ((this.idreslaboratorio == null && other.idreslaboratorio != null) || (this.idreslaboratorio != null && !this.idreslaboratorio.equals(other.idreslaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReservaLab[ idreslaboratorio=" + idreslaboratorio + " ]";
    }
    
}
