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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "baocao")
@NamedQueries({
    @NamedQuery(name = "Baocao.findAll", query = "SELECT b FROM Baocao b")
    , @NamedQuery(name = "Baocao.findById", query = "SELECT b FROM Baocao b WHERE b.id = :id")
    , @NamedQuery(name = "Baocao.findByTen", query = "SELECT b FROM Baocao b WHERE b.ten = :ten")
    , @NamedQuery(name = "Baocao.findByThoiGian", query = "SELECT b FROM Baocao b WHERE b.thoiGian = :thoiGian")})
public class Baocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ten")
    private String ten;
    @Basic(optional = false)
    @Lob
    @Column(name = "TomTat")
    private String tomTat;
    @Basic(optional = false)
    @Column(name = "ThoiGian")
    @Temporal(TemporalType.DATE)
    private Date thoiGian;
    @Basic(optional = false)
    @Lob
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "IDLinhVuc", referencedColumnName = "IDLinhVuc")
    @OneToOne(optional = false)
    private Linhvuc iDLinhVuc;
    @JoinColumn(name = "IDLoai", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Loaibaocao iDLoai;
    @JoinColumn(name = "ID", referencedColumnName = "IDBaoCao", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NhakhoahocBaocao nhakhoahocBaocao;

    public Baocao() {
    }

    public Baocao(Integer id) {
        this.id = id;
    }

    public Baocao(Integer id, String ten, String tomTat, Date thoiGian, String url) {
        this.id = id;
        this.ten = ten;
        this.tomTat = tomTat;
        this.thoiGian = thoiGian;
        this.url = url;
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

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Linhvuc getIDLinhVuc() {
        return iDLinhVuc;
    }

    public void setIDLinhVuc(Linhvuc iDLinhVuc) {
        this.iDLinhVuc = iDLinhVuc;
    }

    public Loaibaocao getIDLoai() {
        return iDLoai;
    }

    public void setIDLoai(Loaibaocao iDLoai) {
        this.iDLoai = iDLoai;
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
        if (!(object instanceof Baocao)) {
            return false;
        }
        Baocao other = (Baocao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Baocao[ id=" + id + " ]";
    }
    
}
