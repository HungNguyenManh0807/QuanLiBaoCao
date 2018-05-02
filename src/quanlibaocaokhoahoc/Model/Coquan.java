/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(catalog = "QuanLiBaoCao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coquan.findAll", query = "SELECT c FROM Coquan c")
    , @NamedQuery(name = "Coquan.findById", query = "SELECT c FROM Coquan c WHERE c.id = :id")
    , @NamedQuery(name = "Coquan.findByTen", query = "SELECT c FROM Coquan c WHERE c.ten = :ten")
    , @NamedQuery(name = "Coquan.findByDiaChi", query = "SELECT c FROM Coquan c WHERE c.diaChi = :diaChi")})
public class Coquan implements Serializable {

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
    @Column(nullable = false, length = 100)
    private String diaChi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDCoQuan", fetch = FetchType.LAZY)
    private List<Nhanghiencuu> nhanghiencuuList;

    public Coquan() {
    }

    public Coquan(Integer id) {
        this.id = id;
    }

    public Coquan(Integer id, String ten, String diaChi) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
        if (!(object instanceof Coquan)) {
            return false;
        }
        Coquan other = (Coquan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ten + "--" +diaChi;
    }
    
}
