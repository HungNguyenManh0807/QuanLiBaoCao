/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chucdanh.findAll", query = "SELECT c FROM Chucdanh c")
    , @NamedQuery(name = "Chucdanh.findById", query = "SELECT c FROM Chucdanh c WHERE c.id = :id")
    , @NamedQuery(name = "Chucdanh.findByTen", query = "SELECT c FROM Chucdanh c WHERE c.ten = :ten")
    , @NamedQuery(name = "Chucdanh.findByNgayCap", query = "SELECT c FROM Chucdanh c WHERE c.ngayCap = :ngayCap")})
public class Chucdanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String ten;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDChucDanh", fetch = FetchType.LAZY)
    private List<Nhanghiencuu> nhanghiencuuList;

    public Chucdanh() {
    }

    public Chucdanh(Integer id) {
        this.id = id;
    }

    public Chucdanh(Integer id, String ten, Date ngayCap) {
        this.id = id;
        this.ten = ten;
        this.ngayCap = ngayCap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    @XmlTransient
    public List<Nhanghiencuu> getNhanghiencuuList() {
        return nhanghiencuuList;
    }

    public void setNhanghiencuuList(List<Nhanghiencuu> nhanghiencuuList) {
        this.nhanghiencuuList = nhanghiencuuList;
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
        if (!(object instanceof Chucdanh)) {
            return false;
        }
        Chucdanh other = (Chucdanh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Chucdanh[ id=" + id + " ]";
    }
    
}
