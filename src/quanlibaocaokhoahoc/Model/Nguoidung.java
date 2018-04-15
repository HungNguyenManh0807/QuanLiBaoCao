/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hung Nguyen
 */
@Entity
@Table(name = "nguoidung", catalog = "quanlibaocao", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n")// Nguoidung la ten class === @Entity(name= Nguoidung)
    , @NamedQuery(name = "Nguoidung.findById", query = "SELECT n FROM Nguoidung n WHERE n.id = :id")// jpa sql id la id trong class Nguoidung
    , @NamedQuery(name = "Nguoidung.findByPassword", query = "SELECT n FROM Nguoidung n WHERE n.password = :password")
    , @NamedQuery(name = "Nguoidung.findByQuyenHan", query = "SELECT n FROM Nguoidung n WHERE n.quyenHan = :quyenHan")})
public class Nguoidung implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false) // column ID trong bang nguoi dung trong database
    private Integer id;
    
    
    @Basic(optional = false)
    @Lob
    @Column(name = "Username", nullable = false, length = 65535)// column username trong bang nguoi dung trong database
    private String username;
    
    
    @Basic(optional = false)
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
    
    
    @Basic(optional = false)
    @Column(name = "QuyenHan", nullable = false)
    private int quyenHan;

    public Nguoidung() {
    }

    public Nguoidung(Integer id) {
        this.id = id;
    }

    public Nguoidung(Integer id, String username, String password, int quyenHan) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.quyenHan = quyenHan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public int getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(int quyenHan) {
        int oldQuyenHan = this.quyenHan;
        this.quyenHan = quyenHan;
        changeSupport.firePropertyChange("quyenHan", oldQuyenHan, quyenHan);
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
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "quanlibaocaokhoahoc.Model.Nguoidung[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
