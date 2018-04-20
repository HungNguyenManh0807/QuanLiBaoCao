/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.Model.Chucdanh;
import quanlibaocaokhoahoc.Model.Coquan;
import quanlibaocaokhoahoc.Model.Nhanghiencuu;

/**
 *
 * @author Hung Nguyen
 */
public class NhanghiencuuJpaController implements Serializable {

    public NhanghiencuuJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nhanghiencuu nhanghiencuu) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chucdanh IDChucDanh = nhanghiencuu.getIDChucDanh();
            if (IDChucDanh != null) {
                IDChucDanh = em.getReference(IDChucDanh.getClass(), IDChucDanh.getId());
                nhanghiencuu.setIDChucDanh(IDChucDanh);
            }
            Coquan IDCoQuan = nhanghiencuu.getIDCoQuan();
            if (IDCoQuan != null) {
                IDCoQuan = em.getReference(IDCoQuan.getClass(), IDCoQuan.getId());
                nhanghiencuu.setIDCoQuan(IDCoQuan);
            }
            em.persist(nhanghiencuu);
            if (IDChucDanh != null) {
                IDChucDanh.getNhanghiencuuList().add(nhanghiencuu);
                IDChucDanh = em.merge(IDChucDanh);
            }
            if (IDCoQuan != null) {
                IDCoQuan.getNhanghiencuuList().add(nhanghiencuu);
                IDCoQuan = em.merge(IDCoQuan);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nhanghiencuu nhanghiencuu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nhanghiencuu persistentNhanghiencuu = em.find(Nhanghiencuu.class, nhanghiencuu.getId());
            Chucdanh IDChucDanhOld = persistentNhanghiencuu.getIDChucDanh();
            Chucdanh IDChucDanhNew = nhanghiencuu.getIDChucDanh();
            Coquan IDCoQuanOld = persistentNhanghiencuu.getIDCoQuan();
            Coquan IDCoQuanNew = nhanghiencuu.getIDCoQuan();
            if (IDChucDanhNew != null) {
                IDChucDanhNew = em.getReference(IDChucDanhNew.getClass(), IDChucDanhNew.getId());
                nhanghiencuu.setIDChucDanh(IDChucDanhNew);
            }
            if (IDCoQuanNew != null) {
                IDCoQuanNew = em.getReference(IDCoQuanNew.getClass(), IDCoQuanNew.getId());
                nhanghiencuu.setIDCoQuan(IDCoQuanNew);
            }
            nhanghiencuu = em.merge(nhanghiencuu);
            if (IDChucDanhOld != null && !IDChucDanhOld.equals(IDChucDanhNew)) {
                IDChucDanhOld.getNhanghiencuuList().remove(nhanghiencuu);
                IDChucDanhOld = em.merge(IDChucDanhOld);
            }
            if (IDChucDanhNew != null && !IDChucDanhNew.equals(IDChucDanhOld)) {
                IDChucDanhNew.getNhanghiencuuList().add(nhanghiencuu);
                IDChucDanhNew = em.merge(IDChucDanhNew);
            }
            if (IDCoQuanOld != null && !IDCoQuanOld.equals(IDCoQuanNew)) {
                IDCoQuanOld.getNhanghiencuuList().remove(nhanghiencuu);
                IDCoQuanOld = em.merge(IDCoQuanOld);
            }
            if (IDCoQuanNew != null && !IDCoQuanNew.equals(IDCoQuanOld)) {
                IDCoQuanNew.getNhanghiencuuList().add(nhanghiencuu);
                IDCoQuanNew = em.merge(IDCoQuanNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nhanghiencuu.getId();
                if (findNhanghiencuu(id) == null) {
                    throw new NonexistentEntityException("The nhanghiencuu with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nhanghiencuu nhanghiencuu;
            try {
                nhanghiencuu = em.getReference(Nhanghiencuu.class, id);
                nhanghiencuu.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nhanghiencuu with id " + id + " no longer exists.", enfe);
            }
            Chucdanh IDChucDanh = nhanghiencuu.getIDChucDanh();
            if (IDChucDanh != null) {
                IDChucDanh.getNhanghiencuuList().remove(nhanghiencuu);
                IDChucDanh = em.merge(IDChucDanh);
            }
            Coquan IDCoQuan = nhanghiencuu.getIDCoQuan();
            if (IDCoQuan != null) {
                IDCoQuan.getNhanghiencuuList().remove(nhanghiencuu);
                IDCoQuan = em.merge(IDCoQuan);
            }
            em.remove(nhanghiencuu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nhanghiencuu> findNhanghiencuuEntities() {
        return findNhanghiencuuEntities(true, -1, -1);
    }

    public List<Nhanghiencuu> findNhanghiencuuEntities(int maxResults, int firstResult) {
        return findNhanghiencuuEntities(false, maxResults, firstResult);
    }

    private List<Nhanghiencuu> findNhanghiencuuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nhanghiencuu.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Nhanghiencuu findNhanghiencuu(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nhanghiencuu.class, id);
        } finally {
            em.close();
        }
    }

    public int getNhanghiencuuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nhanghiencuu> rt = cq.from(Nhanghiencuu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
