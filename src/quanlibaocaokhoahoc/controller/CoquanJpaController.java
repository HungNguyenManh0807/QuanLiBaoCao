/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import quanlibaocaokhoahoc.Model.Nhakhoahoc;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Model.Coquan;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class CoquanJpaController implements Serializable {

    public CoquanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Coquan coquan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nhakhoahoc nhakhoahoc = coquan.getNhakhoahoc();
            if (nhakhoahoc != null) {
                nhakhoahoc = em.getReference(nhakhoahoc.getClass(), nhakhoahoc.getId());
                coquan.setNhakhoahoc(nhakhoahoc);
            }
            em.persist(coquan);
            if (nhakhoahoc != null) {
                Coquan oldIDCoQuanOfNhakhoahoc = nhakhoahoc.getIDCoQuan();
                if (oldIDCoQuanOfNhakhoahoc != null) {
                    oldIDCoQuanOfNhakhoahoc.setNhakhoahoc(null);
                    oldIDCoQuanOfNhakhoahoc = em.merge(oldIDCoQuanOfNhakhoahoc);
                }
                nhakhoahoc.setIDCoQuan(coquan);
                nhakhoahoc = em.merge(nhakhoahoc);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Coquan coquan) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Coquan persistentCoquan = em.find(Coquan.class, coquan.getIDCoQuan());
            Nhakhoahoc nhakhoahocOld = persistentCoquan.getNhakhoahoc();
            Nhakhoahoc nhakhoahocNew = coquan.getNhakhoahoc();
            List<String> illegalOrphanMessages = null;
            if (nhakhoahocOld != null && !nhakhoahocOld.equals(nhakhoahocNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Nhakhoahoc " + nhakhoahocOld + " since its IDCoQuan field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nhakhoahocNew != null) {
                nhakhoahocNew = em.getReference(nhakhoahocNew.getClass(), nhakhoahocNew.getId());
                coquan.setNhakhoahoc(nhakhoahocNew);
            }
            coquan = em.merge(coquan);
            if (nhakhoahocNew != null && !nhakhoahocNew.equals(nhakhoahocOld)) {
                Coquan oldIDCoQuanOfNhakhoahoc = nhakhoahocNew.getIDCoQuan();
                if (oldIDCoQuanOfNhakhoahoc != null) {
                    oldIDCoQuanOfNhakhoahoc.setNhakhoahoc(null);
                    oldIDCoQuanOfNhakhoahoc = em.merge(oldIDCoQuanOfNhakhoahoc);
                }
                nhakhoahocNew.setIDCoQuan(coquan);
                nhakhoahocNew = em.merge(nhakhoahocNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = coquan.getIDCoQuan();
                if (findCoquan(id) == null) {
                    throw new NonexistentEntityException("The coquan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Coquan coquan;
            try {
                coquan = em.getReference(Coquan.class, id);
                coquan.getIDCoQuan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coquan with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Nhakhoahoc nhakhoahocOrphanCheck = coquan.getNhakhoahoc();
            if (nhakhoahocOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Coquan (" + coquan + ") cannot be destroyed since the Nhakhoahoc " + nhakhoahocOrphanCheck + " in its nhakhoahoc field has a non-nullable IDCoQuan field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(coquan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Coquan> findCoquanEntities() {
        return findCoquanEntities(true, -1, -1);
    }

    public List<Coquan> findCoquanEntities(int maxResults, int firstResult) {
        return findCoquanEntities(false, maxResults, firstResult);
    }

    private List<Coquan> findCoquanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Coquan.class));
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

    public Coquan findCoquan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Coquan.class, id);
        } finally {
            em.close();
        }
    }

    public int getCoquanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Coquan> rt = cq.from(Coquan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
