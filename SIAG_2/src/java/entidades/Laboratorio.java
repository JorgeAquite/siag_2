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
@Table(name = "LABORATORIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l"),
    @NamedQuery(name = "Laboratorio.findByIdlaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.idlaboratorio = :idlaboratorio"),
    @NamedQuery(name = "Laboratorio.findBySalon", query = "SELECT l FROM Laboratorio l WHERE l.salon = :salon"),
    @NamedQuery(name = "Laboratorio.findByLaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.laboratorio = :laboratorio")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLABORATORIO")
    private BigDecimal idlaboratorio;
    @Column(name = "SALON")
    private BigInteger salon;
    @Size(max = 256)
    @Column(name = "LABORATORIO")
    private String laboratorio;
    @OneToMany(mappedBy = "idlaboratorio")
    private Collection<ReservaLab> reservaLabCollection;

    public Laboratorio() {
    }

    public Laboratorio(BigDecimal idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public BigDecimal getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(BigDecimal idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public BigInteger getSalon() {
        return salon;
    }

    public void setSalon(BigInteger salon) {
        this.salon = salon;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
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
        hash += (idlaboratorio != null ? idlaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.idlaboratorio == null && other.idlaboratorio != null) || (this.idlaboratorio != null && !this.idlaboratorio.equals(other.idlaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Laboratorio[ idlaboratorio=" + idlaboratorio + " ]";
    }
    
}
