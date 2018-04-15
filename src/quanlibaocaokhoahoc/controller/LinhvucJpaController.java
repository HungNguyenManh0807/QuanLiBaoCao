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
import quanlibaocaokhoahoc.Model.Baocao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Model.Linhvuc;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class LinhvucJpaController implements Serializable {

    public LinhvucJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Linhvuc linhvuc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Baocao baocao = linhvuc.getBaocao();
            if (baocao != null) {
                baocao = em.getReference(baocao.getClass(), baocao.getId());
                linhvuc.setBaocao(baocao);
            }
            em.persist(linhvuc);
            if (baocao != null) {
                Linhvuc oldIDLinhVucOfBaocao = baocao.getIDLinhVuc();
                if (oldIDLinhVucOfBaocao != null) {
                    oldIDLinhVucOfBaocao.setBaocao(null);
                    oldIDLinhVucOfBaocao = em.merge(oldIDLinhVucOfBaocao);
                }
                baocao.setIDLinhVuc(linhvuc);
                baocao = em.merge(baocao);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Linhvuc linhvuc) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Linhvuc persistentLinhvuc = em.find(Linhvuc.class, linhvuc.getIDLinhVuc());
            Baocao baocaoOld = persistentLinhvuc.getBaocao();
            Baocao baocaoNew = linhvuc.getBaocao();
            List<String> illegalOrphanMessages = null;
            if (baocaoOld != null && !baocaoOld.equals(baocaoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Baocao " + baocaoOld + " since its IDLinhVuc field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (baocaoNew != null) {
                baocaoNew = em.getReference(baocaoNew.getClass(), baocaoNew.getId());
                linhvuc.setBaocao(baocaoNew);
            }
            linhvuc = em.merge(linhvuc);
            if (baocaoNew != null && !baocaoNew.equals(baocaoOld)) {
                Linhvuc oldIDLinhVucOfBaocao = baocaoNew.getIDLinhVuc();
                if (oldIDLinhVucOfBaocao != null) {
                    oldIDLinhVucOfBaocao.setBaocao(null);
                    oldIDLinhVucOfBaocao = em.merge(oldIDLinhVucOfBaocao);
                }
                baocaoNew.setIDLinhVuc(linhvuc);
                baocaoNew = em.merge(baocaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = linhvuc.getIDLinhVuc();
                if (findLinhvuc(id) == null) {
                    throw new NonexistentEntityException("The linhvuc with id " + id + " no longer exists.");
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
            Linhvuc linhvuc;
            try {
                linhvuc = em.getReference(Linhvuc.class, id);
                linhvuc.getIDLinhVuc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The linhvuc with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Baocao baocaoOrphanCheck = linhvuc.getBaocao();
            if (baocaoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Linhvuc (" + linhvuc + ") cannot be destroyed since the Baocao " + baocaoOrphanCheck + " in its baocao field has a non-nullable IDLinhVuc field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(linhvuc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Linhvuc> findLinhvucEntities() {
        return findLinhvucEntities(true, -1, -1);
    }

    public List<Linhvuc> findLinhvucEntities(int maxResults, int firstResult) {
        return findLinhvucEntities(false, maxResults, firstResult);
    }

    private List<Linhvuc> findLinhvucEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Linhvuc.class));
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

    public Linhvuc findLinhvuc(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Linhvuc.class, id);
        } finally {
            em.close();
        }
    }

    public int getLinhvucCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Linhvuc> rt = cq.from(Linhvuc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
