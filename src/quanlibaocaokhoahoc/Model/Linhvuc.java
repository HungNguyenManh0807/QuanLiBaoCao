/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "linhvuc", catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhvuc.findAll", query = "SELECT l FROM Linhvuc l")
    , @NamedQuery(name = "Linhvuc.findByIDLinhVuc", query = "SELECT l FROM Linhvuc l WHERE l.iDLinhVuc = :iDLinhVuc")
    , @NamedQuery(name = "Linhvuc.findByTen", query = "SELECT l FROM Linhvuc l WHERE l.ten = :ten")})
public class Linhvuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLinhVuc", nullable = false)
    private Integer iDLinhVuc;
    @Basic(optional = false)
    @Column(name = "Ten", nullable = false, length = 100)
    private String ten;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "iDLinhVuc")
    private Baocao baocao;

    public Linhvuc() {
    }

    public Linhvuc(Integer iDLinhVuc) {
        this.iDLinhVuc = iDLinhVuc;
    }

    public Linhvuc(Integer iDLinhVuc, String ten) {
        this.iDLinhVuc = iDLinhVuc;
        this.ten = ten;
    }

    public Integer getIDLinhVuc() {
        return iDLinhVuc;
    }

    public void setIDLinhVuc(Integer iDLinhVuc) {
        this.iDLinhVuc = iDLinhVuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Baocao getBaocao() {
        return baocao;
    }

    public void setBaocao(Baocao baocao) {
        this.baocao = baocao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLinhVuc != null ? iDLinhVuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhvuc)) {
            return false;
        }
        Linhvuc other = (Linhvuc) object;
        if ((this.iDLinhVuc == null && other.iDLinhVuc != null) || (this.iDLinhVuc != null && !this.iDLinhVuc.equals(other.iDLinhVuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Linhvuc[ iDLinhVuc=" + iDLinhVuc + " ]";
    }
    
}
