/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encje;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name = "ZAMOWIENIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zamowienia.findAll", query = "SELECT z FROM Zamowienia z")
    , @NamedQuery(name = "Zamowienia.findById", query = "SELECT z FROM Zamowienia z WHERE z.id = :id")
    , @NamedQuery(name = "Zamowienia.findByDataZlozeniaZamowienia", query = "SELECT z FROM Zamowienia z WHERE z.dataZlozeniaZamowienia = :dataZlozeniaZamowienia")
    , @NamedQuery(name = "Zamowienia.findByDataWysylki", query = "SELECT z FROM Zamowienia z WHERE z.dataWysylki = :dataWysylki")
    , @NamedQuery(name = "Zamowienia.findByStanZamowienia", query = "SELECT z FROM Zamowienia z WHERE z.stanZamowienia = :stanZamowienia")})
public class Zamowienia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_ZLOZENIA_ZAMOWIENIA")
    @Temporal(TemporalType.DATE)
    private Date dataZlozeniaZamowienia;
    @Column(name = "DATA_WYSYLKI")
    @Temporal(TemporalType.DATE)
    private Date dataWysylki;
    @Size(max = 1)
    @Column(name = "STAN_ZAMOWIENIA")
    private String stanZamowienia;
    @OneToMany(mappedBy = "zamowienia")
    private Collection<ZamowieniaProdukty> zamowieniaProduktyCollection;
    @JoinColumn(name = "ID_DANE_ZAMAWIAJACEGO", referencedColumnName = "ID")
    @ManyToOne
    private DaneZamawiajacego daneZamawiajacego;

    public Zamowienia() {
    }

    public Zamowienia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataZlozeniaZamowienia() {
        return dataZlozeniaZamowienia;
    }

    public void setDataZlozeniaZamowienia(Date dataZlozeniaZamowienia) {
        this.dataZlozeniaZamowienia = dataZlozeniaZamowienia;
    }

    public Date getDataWysylki() {
        return dataWysylki;
    }

    public void setDataWysylki(Date dataWysylki) {
        this.dataWysylki = dataWysylki;
    }

    public String getStanZamowienia() {
        return stanZamowienia;
    }

    public void setStanZamowienia(String stanZamowienia) {
        this.stanZamowienia = stanZamowienia;
    }

    @XmlTransient
    public Collection<ZamowieniaProdukty> getZamowieniaProduktyCollection() {
        return zamowieniaProduktyCollection;
    }

    public void setZamowieniaProduktyCollection(Collection<ZamowieniaProdukty> zamowieniaProduktyCollection) {
        this.zamowieniaProduktyCollection = zamowieniaProduktyCollection;
    }

    public DaneZamawiajacego getDaneZamawiajacego() {
        return daneZamawiajacego;
    }

    public void setDaneZamawiajacego(DaneZamawiajacego daneZamawiajacego) {
        this.daneZamawiajacego = daneZamawiajacego;
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
        if (!(object instanceof Zamowienia)) {
            return false;
        }
        Zamowienia other = (Zamowienia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.Zamowienia[ id=" + id + " ]";
    }
    
}
