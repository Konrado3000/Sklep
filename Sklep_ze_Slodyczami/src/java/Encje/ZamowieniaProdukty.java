/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encje;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name = "ZAMOWIENIA_PRODUKTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZamowieniaProdukty.findAll", query = "SELECT z FROM ZamowieniaProdukty z")
    , @NamedQuery(name = "ZamowieniaProdukty.findById", query = "SELECT z FROM ZamowieniaProdukty z WHERE z.id = :id")})
public class ZamowieniaProdukty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_PRODUKTY", referencedColumnName = "ID")
    @ManyToOne
    private Produkty produkty;
    @JoinColumn(name = "ID_ZAMOWIENIA", referencedColumnName = "ID")
    @ManyToOne
    private Zamowienia zamowienia;

    public ZamowieniaProdukty() {
    }

    public ZamowieniaProdukty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produkty getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkty produkty) {
        this.produkty = produkty;
    }

    public Zamowienia getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Zamowienia zamowienia) {
        this.zamowienia = zamowienia;
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
        if (!(object instanceof ZamowieniaProdukty)) {
            return false;
        }
        ZamowieniaProdukty other = (ZamowieniaProdukty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Encje.ZamowieniaProdukty[ id=" + id + " ]";
    }
    
}
