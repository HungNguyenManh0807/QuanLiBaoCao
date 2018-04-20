/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "nhanghiencuu_baocao", catalog = "quanlibaocao", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanghiencuuBaocao.findAll", query = "SELECT n FROM NhanghiencuuBaocao n")
    , @NamedQuery(name = "NhanghiencuuBaocao.findByIDBaoCao", query = "SELECT n FROM NhanghiencuuBaocao n WHERE n.nhanghiencuuBaocaoPK.iDBaoCao = :iDBaoCao")
    , @NamedQuery(name = "NhanghiencuuBaocao.findByIDNguoiNghienCuu", query = "SELECT n FROM NhanghiencuuBaocao n WHERE n.nhanghiencuuBaocaoPK.iDNguoiNghienCuu = :iDNguoiNghienCuu")})
public class NhanghiencuuBaocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NhanghiencuuBaocaoPK nhanghiencuuBaocaoPK;
    @JoinColumn(name = "IDVaiTro", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vaitro iDVaiTro;

    public NhanghiencuuBaocao() {
    }

    public NhanghiencuuBaocao(NhanghiencuuBaocaoPK nhanghiencuuBaocaoPK) {
        this.nhanghiencuuBaocaoPK = nhanghiencuuBaocaoPK;
    }

    public NhanghiencuuBaocao(int iDBaoCao, int iDNguoiNghienCuu) {
        this.nhanghiencuuBaocaoPK = new NhanghiencuuBaocaoPK(iDBaoCao, iDNguoiNghienCuu);
    }

    public NhanghiencuuBaocaoPK getNhanghiencuuBaocaoPK() {
        return nhanghiencuuBaocaoPK;
    }

    public void setNhanghiencuuBaocaoPK(NhanghiencuuBaocaoPK nhanghiencuuBaocaoPK) {
        this.nhanghiencuuBaocaoPK = nhanghiencuuBaocaoPK;
    }

    public Vaitro getIDVaiTro() {
        return iDVaiTro;
    }

    public void setIDVaiTro(Vaitro iDVaiTro) {
        this.iDVaiTro = iDVaiTro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nhanghiencuuBaocaoPK != null ? nhanghiencuuBaocaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanghiencuuBaocao)) {
            return false;
        }
        NhanghiencuuBaocao other = (NhanghiencuuBaocao) object;
        if ((this.nhanghiencuuBaocaoPK == null && other.nhanghiencuuBaocaoPK != null) || (this.nhanghiencuuBaocaoPK != null && !this.nhanghiencuuBaocaoPK.equals(other.nhanghiencuuBaocaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.NhanghiencuuBaocao[ nhanghiencuuBaocaoPK=" + nhanghiencuuBaocaoPK + " ]";
    }
    
}
