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
@Table(name = "DANE_ZAMAWIAJACEGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaneZamawiajacego.findAll", query = "SELECT d FROM DaneZamawiajacego d")
    , @NamedQuery(name = "DaneZamawiajacego.findById", query = "SELECT d FROM DaneZamawiajacego d WHERE d.id = :id")
    , @NamedQuery(name = "DaneZamawiajacego.findByImie", query = "SELECT d FROM DaneZamawiajacego d WHERE d.imie = :imie")
    , @NamedQuery(name = "DaneZamawiajacego.findByNazwisko", query = "SELECT d FROM DaneZamawiajacego d WHERE d.nazwisko = :nazwisko")
    , @NamedQuery(name = "DaneZamawiajacego.findByAdres", query = "SELECT d FROM DaneZamawiajacego d WHERE d.adres = :adres")
    , @NamedQuery(name = "DaneZamawiajacego.findByKontakt", query = "SELECT d FROM DaneZamawiajacego d WHERE d.kontakt = :kontakt")})
public class DaneZamawiajacego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 15)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 15)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 20)
    @Column(name = "ADRES")
    private String adres;
    @Size(max = 30)
    @Column(name = "KONTAKT")
    private String kontakt;
    @OneToMany(mappedBy = "daneZamawiajacego")
    private Collection<Zamowienia> zamowieniaCollection;

    public DaneZamawiajacego() {
    }

    public DaneZamawiajacego(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @XmlTransient
    public Collection<Zamowienia> getZamowieniaCollection() {
        return zamowieniaCollection;
    }

    public void setZamowieniaCollection(Collection<Zamowienia> zamowieniaCollection) {
        this.zamowieniaCollection = zamowieniaCollection;
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
        if (!(object instanceof DaneZamawiajacego)) {
            return false;
        }
        DaneZamawiajacego other = (DaneZamawiajacego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.DaneZamawiajacego[ id=" + id + " ]";
    }
    
}
