/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "nhakhoahoc", catalog = "quanlibaocao", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"IDCoQuan"})
    , @UniqueConstraint(columnNames = {"IDChucDanh"})
    ,@UniqueConstraint(columnNames = "ID")})
    
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhakhoahoc.findAll", query = "SELECT n FROM Nhakhoahoc n")
    , @NamedQuery(name = "Nhakhoahoc.findById", query = "SELECT n FROM Nhakhoahoc n WHERE n.id = :id")
    , @NamedQuery(name = "Nhakhoahoc.findByTen", query = "SELECT n FROM Nhakhoahoc n WHERE n.ten = :ten")
    , @NamedQuery(name = "Nhakhoahoc.findByNgaySinh", query = "SELECT n FROM Nhakhoahoc n WHERE n.ngaySinh = :ngaySinh")})
public class Nhakhoahoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ten", nullable = false, length = 30)
    private String ten;
    @Basic(optional = false)
    @Column(name = "NgaySinh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @JoinColumn(name = "IDChucDanh", referencedColumnName = "ID", nullable = false)
    @OneToOne(optional = false)
    private Chucdanh iDChucDanh;
    @JoinColumn(name = "IDCoQuan", referencedColumnName = "IDCoQuan", nullable = false)
    @OneToOne(optional = false)
    private Coquan iDCoQuan;
    @JoinColumn(name = "ID", referencedColumnName = "IDNguoiNghienCuu", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NhakhoahocBaocao nhakhoahocBaocao;

    public Nhakhoahoc() {
    }

    public Nhakhoahoc(Integer id) {
        this.id = id;
    }

    public Nhakhoahoc(Integer id, String ten, Date ngaySinh) {
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

    public NhakhoahocBaocao getNhakhoahocBaocao() {
        return nhakhoahocBaocao;
    }

    public void setNhakhoahocBaocao(NhakhoahocBaocao nhakhoahocBaocao) {
        this.nhakhoahocBaocao = nhakhoahocBaocao;
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
        if (!(object instanceof Nhakhoahoc)) {
            return false;
        }
        Nhakhoahoc other = (Nhakhoahoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Nhakhoahoc[ id=" + id + " ]";
    }

}
