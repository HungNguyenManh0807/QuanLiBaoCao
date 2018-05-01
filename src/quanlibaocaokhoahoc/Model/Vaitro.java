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
    @NamedQuery(name = "Vaitro.findAll", query = "SELECT v FROM Vaitro v")
    , @NamedQuery(name = "Vaitro.findById", query = "SELECT v FROM Vaitro v WHERE v.id = :id")
    , @NamedQuery(name = "Vaitro.findByTen", query = "SELECT v FROM Vaitro v WHERE v.ten = :ten")})
public class Vaitro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDVaiTro", fetch = FetchType.LAZY)
    private List<NhanghiencuuBaocao> nhanghiencuuBaocaoList;

    public Vaitro() {
    }

    public Vaitro(Integer id) {
        this.id = id;
    }

    public Vaitro(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
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
        if (!(object instanceof Vaitro)) {
            return false;
        }
        Vaitro other = (Vaitro) object;
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
