/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hung Nguyen
 */
@Embeddable
public class NhakhoahocBaocaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDBaoCao", nullable = false)
    private int iDBaoCao;
    @Basic(optional = false)
    @Column(name = "IDNguoiNghienCuu", nullable = false)
    private int iDNguoiNghienCuu;

    public NhakhoahocBaocaoPK() {
    }

    public NhakhoahocBaocaoPK(int iDBaoCao, int iDNguoiNghienCuu) {
        this.iDBaoCao = iDBaoCao;
        this.iDNguoiNghienCuu = iDNguoiNghienCuu;
    }

    public int getIDBaoCao() {
        return iDBaoCao;
    }

    public void setIDBaoCao(int iDBaoCao) {
        this.iDBaoCao = iDBaoCao;
    }

    public int getIDNguoiNghienCuu() {
        return iDNguoiNghienCuu;
    }

    public void setIDNguoiNghienCuu(int iDNguoiNghienCuu) {
        this.iDNguoiNghienCuu = iDNguoiNghienCuu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDBaoCao;
        hash += (int) iDNguoiNghienCuu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhakhoahocBaocaoPK)) {
            return false;
        }
        NhakhoahocBaocaoPK other = (NhakhoahocBaocaoPK) object;
        if (this.iDBaoCao != other.iDBaoCao) {
            return false;
        }
        if (this.iDNguoiNghienCuu != other.iDNguoiNghienCuu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.NhakhoahocBaocaoPK[ iDBaoCao=" + iDBaoCao + ", iDNguoiNghienCuu=" + iDNguoiNghienCuu + " ]";
    }
    
}
