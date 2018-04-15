/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
// vi du ty ve git hub
/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "nhakhoahoc_baocao", catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhakhoahocBaocao.findAll", query = "SELECT n FROM NhakhoahocBaocao n")
    , @NamedQuery(name = "NhakhoahocBaocao.findByIDBaoCao", query = "SELECT n FROM NhakhoahocBaocao n WHERE n.nhakhoahocBaocaoPK.iDBaoCao = :iDBaoCao")
    , @NamedQuery(name = "NhakhoahocBaocao.findByIDNguoiNghienCuu", query = "SELECT n FROM NhakhoahocBaocao n WHERE n.nhakhoahocBaocaoPK.iDNguoiNghienCuu = :iDNguoiNghienCuu")})
public class NhakhoahocBaocao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NhakhoahocBaocaoPK nhakhoahocBaocaoPK;
    @JoinColumn(name = "IDVaiTro", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
//    @JoinColumn(name ="IDChucDanh", referencedColumnName = "IDba")
    private Vaitro iDVaiTro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhakhoahocBaocao")
    private Baocao baocao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhakhoahocBaocao")
    private Nhakhoahoc nhakhoahoc;

    public NhakhoahocBaocao() {
    }

    public NhakhoahocBaocao(NhakhoahocBaocaoPK nhakhoahocBaocaoPK) {
        this.nhakhoahocBaocaoPK = nhakhoahocBaocaoPK;
    }

    public NhakhoahocBaocao(int iDBaoCao, int iDNguoiNghienCuu) {
        this.nhakhoahocBaocaoPK = new NhakhoahocBaocaoPK(iDBaoCao, iDNguoiNghienCuu);
    }

    public NhakhoahocBaocaoPK getNhakhoahocBaocaoPK() {
        return nhakhoahocBaocaoPK;
    }

    public void setNhakhoahocBaocaoPK(NhakhoahocBaocaoPK nhakhoahocBaocaoPK) {
        this.nhakhoahocBaocaoPK = nhakhoahocBaocaoPK;
    }

    public Vaitro getIDVaiTro() {
        return iDVaiTro;
    }

    public void setIDVaiTro(Vaitro iDVaiTro) {
        this.iDVaiTro = iDVaiTro;
    }

    public Baocao getBaocao() {
        return baocao;
    }

    public void setBaocao(Baocao baocao) {
        this.baocao = baocao;
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
        hash += (nhakhoahocBaocaoPK != null ? nhakhoahocBaocaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhakhoahocBaocao)) {
            return false;
        }
        NhakhoahocBaocao other = (NhakhoahocBaocao) object;
        if ((this.nhakhoahocBaocaoPK == null && other.nhakhoahocBaocaoPK != null) || (this.nhakhoahocBaocaoPK != null && !this.nhakhoahocBaocaoPK.equals(other.nhakhoahocBaocaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.NhakhoahocBaocao[ nhakhoahocBaocaoPK=" + nhakhoahocBaocaoPK + " ]";
    }
    
}
