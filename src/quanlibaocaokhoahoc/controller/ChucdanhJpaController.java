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
import quanlibaocaokhoahoc.Model.Chucdanh;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class ChucdanhJpaController implements Serializable {

    public ChucdanhJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Chucdanh chucdanh) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nhakhoahoc nhakhoahoc = chucdanh.getNhakhoahoc();
            if (nhakhoahoc != null) {
                nhakhoahoc = em.getReference(nhakhoahoc.getClass(), nhakhoahoc.getId());
                chucdanh.setNhakhoahoc(nhakhoahoc);
            }
            em.persist(chucdanh);
            if (nhakhoahoc != null) {
                Chucdanh oldIDChucDanhOfNhakhoahoc = nhakhoahoc.getIDChucDanh();
                if (oldIDChucDanhOfNhakhoahoc != null) {
                    oldIDChucDanhOfNhakhoahoc.setNhakhoahoc(null);
                    oldIDChucDanhOfNhakhoahoc = em.merge(oldIDChucDanhOfNhakhoahoc);
                }
                nhakhoahoc.setIDChucDanh(chucdanh);
                nhakhoahoc = em.merge(nhakhoahoc);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chucdanh chucdanh) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chucdanh persistentChucdanh = em.find(Chucdanh.class, chucdanh.getId());
            Nhakhoahoc nhakhoahocOld = persistentChucdanh.getNhakhoahoc();
            Nhakhoahoc nhakhoahocNew = chucdanh.getNhakhoahoc();
            List<String> illegalOrphanMessages = null;
            if (nhakhoahocOld != null && !nhakhoahocOld.equals(nhakhoahocNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Nhakhoahoc " + nhakhoahocOld + " since its IDChucDanh field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nhakhoahocNew != null) {
                nhakhoahocNew = em.getReference(nhakhoahocNew.getClass(), nhakhoahocNew.getId());
                chucdanh.setNhakhoahoc(nhakhoahocNew);
            }
            chucdanh = em.merge(chucdanh);
            if (nhakhoahocNew != null && !nhakhoahocNew.equals(nhakhoahocOld)) {
                Chucdanh oldIDChucDanhOfNhakhoahoc = nhakhoahocNew.getIDChucDanh();
                if (oldIDChucDanhOfNhakhoahoc != null) {
                    oldIDChucDanhOfNhakhoahoc.setNhakhoahoc(null);
                    oldIDChucDanhOfNhakhoahoc = em.merge(oldIDChucDanhOfNhakhoahoc);
                }
                nhakhoahocNew.setIDChucDanh(chucdanh);
                nhakhoahocNew = em.merge(nhakhoahocNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = chucdanh.getId();
                if (findChucdanh(id) == null) {
                    throw new NonexistentEntityException("The chucdanh with id " + id + " no longer exists.");
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
            Chucdanh chucdanh;
            try {
                chucdanh = em.getReference(Chucdanh.class, id);
                chucdanh.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The chucdanh with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Nhakhoahoc nhakhoahocOrphanCheck = chucdanh.getNhakhoahoc();
            if (nhakhoahocOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Chucdanh (" + chucdanh + ") cannot be destroyed since the Nhakhoahoc " + nhakhoahocOrphanCheck + " in its nhakhoahoc field has a non-nullable IDChucDanh field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(chucdanh);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chucdanh> findChucdanhEntities() {
        return findChucdanhEntities(true, -1, -1);
    }

    public List<Chucdanh> findChucdanhEntities(int maxResults, int firstResult) {
        return findChucdanhEntities(false, maxResults, firstResult);
    }

    private List<Chucdanh> findChucdanhEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chucdanh.class));
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

    public Chucdanh findChucdanh(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chucdanh.class, id);
        } finally {
            em.close();
        }
    }

    public int getChucdanhCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chucdanh> rt = cq.from(Chucdanh.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
