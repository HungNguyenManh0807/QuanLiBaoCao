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
@Table(name = "loaibaocao", catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaibaocao.findAll", query = "SELECT l FROM Loaibaocao l")
    , @NamedQuery(name = "Loaibaocao.findById", query = "SELECT l FROM Loaibaocao l WHERE l.id = :id")
    , @NamedQuery(name = "Loaibaocao.findByLoaiBaoCao", query = "SELECT l FROM Loaibaocao l WHERE l.loaiBaoCao = :loaiBaoCao")})
public class Loaibaocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LoaiBaoCao", nullable = false, length = 100)
    private String loaiBaoCao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "iDLoai")
    private Baocao baocao;

    public Loaibaocao() {
    }

    public Loaibaocao(Integer id) {
        this.id = id;
    }

    public Loaibaocao(Integer id, String loaiBaoCao) {
        this.id = id;
        this.loaiBaoCao = loaiBaoCao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiBaoCao() {
        return loaiBaoCao;
    }

    public void setLoaiBaoCao(String loaiBaoCao) {
        this.loaiBaoCao = loaiBaoCao;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaibaocao)) {
            return false;
        }
        Loaibaocao other = (Loaibaocao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Loaibaocao[ id=" + id + " ]";
    }
    
}
