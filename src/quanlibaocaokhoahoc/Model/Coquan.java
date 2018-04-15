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
@Table(name = "coquan", catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coquan.findAll", query = "SELECT c FROM Coquan c")
    , @NamedQuery(name = "Coquan.findByIDCoQuan", query = "SELECT c FROM Coquan c WHERE c.iDCoQuan = :iDCoQuan")
    , @NamedQuery(name = "Coquan.findByTen", query = "SELECT c FROM Coquan c WHERE c.ten = :ten")
    , @NamedQuery(name = "Coquan.findByDiaChi", query = "SELECT c FROM Coquan c WHERE c.diaChi = :diaChi")})
public class Coquan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCoQuan", nullable = false)
    private Integer iDCoQuan;
    @Basic(optional = false)
    @Column(name = "Ten", nullable = false)
    private int ten;
    @Basic(optional = false)
    @Column(name = "DiaChi", nullable = false, length = 100)
    private String diaChi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "iDCoQuan")
    private Nhakhoahoc nhakhoahoc;

    public Coquan() {
    }

    public Coquan(Integer iDCoQuan) {
        this.iDCoQuan = iDCoQuan;
    }

    public Coquan(Integer iDCoQuan, int ten, String diaChi) {
        this.iDCoQuan = iDCoQuan;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public Integer getIDCoQuan() {
        return iDCoQuan;
    }

    public void setIDCoQuan(Integer iDCoQuan) {
        this.iDCoQuan = iDCoQuan;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Nhakhoahoc getNhakhoahoc() {
        return nhakhoahoc;
    }

    public void setNhakhoahoc(Nhakhoahoc nhakhoahoc) {
        this.nhakhoahoc = nhakhoahoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCoQuan != null ? iDCoQuan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coquan)) {
            return false;
        }
        Coquan other = (Coquan) object;
        if ((this.iDCoQuan == null && other.iDCoQuan != null) || (this.iDCoQuan != null && !this.iDCoQuan.equals(other.iDCoQuan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Coquan[ iDCoQuan=" + iDCoQuan + " ]";
    }
    
}
