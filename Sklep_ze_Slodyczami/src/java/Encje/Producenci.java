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
@Table(name = "PRODUCENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producenci.findAll", query = "SELECT p FROM Producenci p")
    , @NamedQuery(name = "Producenci.findById", query = "SELECT p FROM Producenci p WHERE p.id = :id")
    , @NamedQuery(name = "Producenci.findByNazwa", query = "SELECT p FROM Producenci p WHERE p.nazwa = :nazwa")})
public class Producenci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(mappedBy = "producenci")
    private Collection<KategorieProducenci> kategorieProducenciCollection;

    public Producenci() {
    }

    public Producenci(Integer id) {
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
        if (!(object instanceof Producenci)) {
            return false;
        }
        Producenci other = (Producenci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Producenci[ id=" + id + " ]";
    }
    
}
