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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PRACTICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practica.findAll", query = "SELECT p FROM Practica p"),
    @NamedQuery(name = "Practica.findByIdpractica", query = "SELECT p FROM Practica p WHERE p.idpractica = :idpractica"),
    @NamedQuery(name = "Practica.findByPractica", query = "SELECT p FROM Practica p WHERE p.practica = :practica")})
public class Practica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRACTICA")
    private BigDecimal idpractica;
    @Size(max = 256)
    @Column(name = "PRACTICA")
    private String practica;
    @JoinColumn(name = "IDPROGRAMA", referencedColumnName = "IDPROGRAMA")
    @ManyToOne
    private Programa idprograma;
    @OneToMany(mappedBy = "idpractica")
    private Collection<ReservaLab> reservaLabCollection;

    public Practica() {
    }

    public Practica(BigDecimal idpractica) {
        this.idpractica = idpractica;
    }

    public BigDecimal getIdpractica() {
        return idpractica;
    }

    public void setIdpractica(BigDecimal idpractica) {
        this.idpractica = idpractica;
    }

    public String getPractica() {
        return practica;
    }

    public void setPractica(String practica) {
        this.practica = practica;
    }

    public Programa getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Programa idprograma) {
        this.idprograma = idprograma;
    }

    @XmlTransient
    public Collection<ReservaLab> getReservaLabCollection() {
        return reservaLabCollection;
    }

    public void setReservaLabCollection(Collection<ReservaLab> reservaLabCollection) {
        this.reservaLabCollection = reservaLabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpractica != null ? idpractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica)) {
            return false;
        }
        Practica other = (Practica) object;
        if ((this.idpractica == null && other.idpractica != null) || (this.idpractica != null && !this.idpractica.equals(other.idpractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Practica[ idpractica=" + idpractica + " ]";
    }
    
}
