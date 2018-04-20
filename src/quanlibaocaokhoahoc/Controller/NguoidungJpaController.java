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
import quanlibaocaokhoahoc.Model.Nguoidung;

/**
 *
 * @author Hung Nguyen
 */
public class NguoidungJpaController implements Serializable {

    public NguoidungJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nguoidung nguoidung) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nguoidung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nguoidung nguoidung) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nguoidung = em.merge(nguoidung);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nguoidung.getId();
                if (findNguoidung(id) == null) {
                    throw new NonexistentEntityException("The nguoidung with id " + id + " no longer exists.");
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
            Nguoidung nguoidung;
            try {
                nguoidung = em.getReference(Nguoidung.class, id);
                nguoidung.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nguoidung with id " + id + " no longer exists.", enfe);
            }
            em.remove(nguoidung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nguoidung> findNguoidungEntities() {
        return findNguoidungEntities(true, -1, -1);
    }

    public List<Nguoidung> findNguoidungEntities(int maxResults, int firstResult) {
        return findNguoidungEntities(false, maxResults, firstResult);
    }

    private List<Nguoidung> findNguoidungEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nguoidung.class));
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

    public Nguoidung findNguoidung(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nguoidung.class, id);
        } finally {
            em.close();
        }
    }

    public int getNguoidungCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nguoidung> rt = cq.from(Nguoidung.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
