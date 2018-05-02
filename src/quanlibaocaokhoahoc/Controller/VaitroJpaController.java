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
import quanlibaocaokhoahoc.Model.Vaitro;

/**
 *
 * @author Hung Nguyen
 */
public class VaitroJpaController implements Serializable {

    public VaitroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vaitro vaitro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vaitro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vaitro vaitro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vaitro = em.merge(vaitro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vaitro.getId();
                if (findVaitro(id) == null) {
                    throw new NonexistentEntityException("The vaitro with id " + id + " no longer exists.");
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
            Vaitro vaitro;
            try {
                vaitro = em.getReference(Vaitro.class, id);
                vaitro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vaitro with id " + id + " no longer exists.", enfe);
            }
            em.remove(vaitro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vaitro> findVaitroEntities() {
        return findVaitroEntities(true, -1, -1);
    }

    public List<Vaitro> findVaitroEntities(int maxResults, int firstResult) {
        return findVaitroEntities(false, maxResults, firstResult);
    }

    private List<Vaitro> findVaitroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vaitro.class));
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

    public Vaitro findVaitro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vaitro.class, id);
        } finally {
            em.close();
        }
    }

    public int getVaitroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vaitro> rt = cq.from(Vaitro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
