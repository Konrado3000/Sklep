/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encje;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name = "KATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorie.findAll", query = "SELECT k FROM Kategorie k")
    , @NamedQuery(name = "Kategorie.findById", query = "SELECT k FROM Kategorie k WHERE k.id = :id")
    , @NamedQuery(name = "Kategorie.findByNazwa", query = "SELECT k FROM Kategorie k WHERE k.nazwa = :nazwa")})
public class Kategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(mappedBy = "kategorie")
    private Collection<KategorieProducenci> kategorieProducenciCollection;

    public Kategorie() {
    }

    public Kategorie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<KategorieProducenci> getKategorieProducenciCollection() {
        return kategorieProducenciCollection;
    }

    public void setKategorieProducenciCollection(Collection<KategorieProducenci> kategorieProducenciCollection) {
        this.kategorieProducenciCollection = kategorieProducenciCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorie)) {
            return false;
        }
        Kategorie other = (Kategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Kategorie[ id=" + id + " ]";
    }
    
}
