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
@Table(name = "PROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdprograma", query = "SELECT p FROM Programa p WHERE p.idprograma = :idprograma"),
    @NamedQuery(name = "Programa.findByPrograma", query = "SELECT p FROM Programa p WHERE p.programa = :programa")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROGRAMA")
    private BigDecimal idprograma;
    @Size(max = 256)
    @Column(name = "PROGRAMA")
    private String programa;
    @OneToMany(mappedBy = "idprograma")
    private Collection<Practica> practicaCollection;

    public Programa() {
    }

    public Programa(BigDecimal idprograma) {
        this.idprograma = idprograma;
    }

    public BigDecimal getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(BigDecimal idprograma) {
        this.idprograma = idprograma;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @XmlTransient
    public Collection<Practica> getPracticaCollection() {
        return practicaCollection;
    }

    public void setPracticaCollection(Collection<Practica> practicaCollection) {
        this.practicaCollection = practicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprograma != null ? idprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idprograma == null && other.idprograma != null) || (this.idprograma != null && !this.idprograma.equals(other.idprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Programa[ idprograma=" + idprograma + " ]";
    }
    
}
