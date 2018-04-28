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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "QuanLiBaoCao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanghiencuu.findAll", query = "SELECT n FROM Nhanghiencuu n")
    , @NamedQuery(name = "Nhanghiencuu.findById", query = "SELECT n FROM Nhanghiencuu n WHERE n.id = :id")
    , @NamedQuery(name = "Nhanghiencuu.findByTen", query = "SELECT n FROM Nhanghiencuu n WHERE n.ten = :ten")
    , @NamedQuery(name = "Nhanghiencuu.findByNgaySinh", query = "SELECT n FROM Nhanghiencuu n WHERE n.ngaySinh = :ngaySinh")})
public class Nhanghiencuu implements Serializable {

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
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @JoinColumn(name = "IDChucDanh", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Chucdanh iDChucDanh;
    @JoinColumn(name = "IDCoQuan", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Coquan iDCoQuan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanghiencuu", fetch = FetchType.LAZY)
    private List<NhanghiencuuBaocao> nhanghiencuuBaocaoList;

    public Nhanghiencuu() {
    }

    public Nhanghiencuu(Integer id) {
        this.id = id;
    }

    public Nhanghiencuu(Integer id, String ten, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Chucdanh getIDChucDanh() {
        return iDChucDanh;
    }

    public void setIDChucDanh(Chucdanh iDChucDanh) {
        this.iDChucDanh = iDChucDanh;
    }

    public Coquan getIDCoQuan() {
        return iDCoQuan;
    }

    public void setIDCoQuan(Coquan iDCoQuan) {
        this.iDCoQuan = iDCoQuan;
    }

    @XmlTransient
    public List<NhanghiencuuBaocao> getNhanghiencuuBaocaoList() {
        return nhanghiencuuBaocaoList;
    }

    public void setNhanghiencuuBaocaoList(List<NhanghiencuuBaocao> nhanghiencuuBaocaoList) {
        this.nhanghiencuuBaocaoList = nhanghiencuuBaocaoList;
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
        if (!(object instanceof Nhanghiencuu)) {
            return false;
        }
        Nhanghiencuu other = (Nhanghiencuu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ten;
    }
    
}
