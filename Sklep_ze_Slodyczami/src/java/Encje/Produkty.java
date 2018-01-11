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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name = "PRODUKTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkty.findAll", query = "SELECT p FROM Produkty p")
    , @NamedQuery(name = "Produkty.findById", query = "SELECT p FROM Produkty p WHERE p.id = :id")
    , @NamedQuery(name = "Produkty.findByNazwa", query = "SELECT p FROM Produkty p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Produkty.findByTyp", query = "SELECT p FROM Produkty p WHERE p.typ = :typ")
    , @NamedQuery(name = "Produkty.findByOpis", query = "SELECT p FROM Produkty p WHERE p.opis = :opis")
    , @NamedQuery(name = "Produkty.findByCenaBrutto", query = "SELECT p FROM Produkty p WHERE p.cenaBrutto = :cenaBrutto")
    , @NamedQuery(name = "Produkty.findByCenaNetto", query = "SELECT p FROM Produkty p WHERE p.cenaNetto = :cenaNetto")})
public class Produkty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAZWA")
    private String nazwa;
    @Size(max = 30)
    @Column(name = "TYP")
    private String typ;
    @Size(max = 50)
    @Column(name = "OPIS")
    private String opis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CENA_BRUTTO")
    private Double cenaBrutto;
    @Column(name = "CENA_NETTO")
    private Double cenaNetto;
    @JoinColumn(name = "ID_KATEGORIE_PRODUCENCI", referencedColumnName = "ID")
    @ManyToOne
    private KategorieProducenci kategorieProducenci;
    @OneToMany(mappedBy = "produkty")
    private Collection<ZamowieniaProdukty> zamowieniaProduktyCollection;

    public Produkty() {
    }

    public Produkty(Integer id) {
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(Double cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    public Double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(Double cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public KategorieProducenci getKategorieProducenci() {
        return kategorieProducenci;
    }

    public void setKategorieProducenci(KategorieProducenci kategorieProducenci) {
        this.kategorieProducenci = kategorieProducenci;
    }

    @XmlTransient
    public Collection<ZamowieniaProdukty> getZamowieniaProduktyCollection() {
        return zamowieniaProduktyCollection;
    }

    public void setZamowieniaProduktyCollection(Collection<ZamowieniaProdukty> zamowieniaProduktyCollection) {
        this.zamowieniaProduktyCollection = zamowieniaProduktyCollection;
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
        if (!(object instanceof Produkty)) {
            return false;
        }
        Produkty other = (Produkty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Produkty[ id=" + id + " ]";
    }
    
}
