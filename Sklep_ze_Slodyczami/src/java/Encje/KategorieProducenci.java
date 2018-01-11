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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name = "KATEGORIE_PRODUCENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KategorieProducenci.findAll", query = "SELECT k FROM KategorieProducenci k")
    , @NamedQuery(name = "KategorieProducenci.findById", query = "SELECT k FROM KategorieProducenci k WHERE k.id = :id")})
public class KategorieProducenci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_KATEGORIE", referencedColumnName = "ID")
    @ManyToOne
    private Kategorie kategorie;
    @JoinColumn(name = "ID_PRODUCENCI", referencedColumnName = "ID")
    @ManyToOne
    private Producenci producenci;
    @OneToMany(mappedBy = "kategorieProducenci")
    private Collection<Produkty> produktyCollection;

    public KategorieProducenci() {
    }

    public KategorieProducenci(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Producenci getProducenci() {
        return producenci;
    }

    public void setProducenci(Producenci producenci) {
        this.producenci = producenci;
    }

    @XmlTransient
    public Collection<Produkty> getProduktyCollection() {
        return produktyCollection;
    }

    public void setProduktyCollection(Collection<Produkty> produktyCollection) {
        this.produktyCollection = produktyCollection;
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
        if (!(object instanceof KategorieProducenci)) {
            return false;
        }
        KategorieProducenci other = (KategorieProducenci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.KategorieProducenci[ id=" + id + " ]";
    }
    
}
