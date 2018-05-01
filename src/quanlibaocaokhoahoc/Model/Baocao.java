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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Baocao.findAll", query = "SELECT b FROM Baocao b")
    , @NamedQuery(name = "Baocao.findById", query = "SELECT b FROM Baocao b WHERE b.id = :id")
    , @NamedQuery(name = "Baocao.findByTen", query = "SELECT b FROM Baocao b WHERE b.ten = :ten")
    , @NamedQuery(name = "Baocao.findByThoiGian", query = "SELECT b FROM Baocao b WHERE b.thoiGian = :thoiGian")})
public class Baocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String ten;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String tomTat;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date thoiGian;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String url;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String urlData;
    @JoinColumn(name = "IDLinhVuc", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Linhvuc iDLinhVuc;
    @JoinColumn(name = "IDLoai", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Loaibaocao iDLoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baocao", fetch = FetchType.LAZY)
    private List<NhanghiencuuBaocao> nhanghiencuuBaocaoList;

    public Baocao() {
    }

    public Baocao(Integer id) {
        this.id = id;
    }

    public Baocao(Integer id, String ten, String tomTat, Date thoiGian, String url, String urlData) {
        this.id = id;
        this.ten = ten;
        this.tomTat = tomTat;
        this.thoiGian = thoiGian;
        this.url = url;
        this.urlData = urlData;
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

    public String getUrlData() {
        return urlData;
    }

    public void setUrlData(String urlData) {
        this.urlData = urlData;
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
        return ten;
    }
    
}
