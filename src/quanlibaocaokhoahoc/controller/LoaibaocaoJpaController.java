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
import quanlibaocaokhoahoc.Model.Loaibaocao;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class LoaibaocaoJpaController implements Serializable {

    public LoaibaocaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Loaibaocao loaibaocao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Baocao baocao = loaibaocao.getBaocao();
            if (baocao != null) {
                baocao = em.getReference(baocao.getClass(), baocao.getId());
                loaibaocao.setBaocao(baocao);
            }
            em.persist(loaibaocao);
            if (baocao != null) {
                Loaibaocao oldIDLoaiOfBaocao = baocao.getIDLoai();
                if (oldIDLoaiOfBaocao != null) {
                    oldIDLoaiOfBaocao.setBaocao(null);
                    oldIDLoaiOfBaocao = em.merge(oldIDLoaiOfBaocao);
                }
                baocao.setIDLoai(loaibaocao);
                baocao = em.merge(baocao);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Loaibaocao loaibaocao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loaibaocao persistentLoaibaocao = em.find(Loaibaocao.class, loaibaocao.getId());
            Baocao baocaoOld = persistentLoaibaocao.getBaocao();
            Baocao baocaoNew = loaibaocao.getBaocao();
            List<String> illegalOrphanMessages = null;
            if (baocaoOld != null && !baocaoOld.equals(baocaoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Baocao " + baocaoOld + " since its IDLoai field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (baocaoNew != null) {
                baocaoNew = em.getReference(baocaoNew.getClass(), baocaoNew.getId());
                loaibaocao.setBaocao(baocaoNew);
            }
            loaibaocao = em.merge(loaibaocao);
            if (baocaoNew != null && !baocaoNew.equals(baocaoOld)) {
                Loaibaocao oldIDLoaiOfBaocao = baocaoNew.getIDLoai();
                if (oldIDLoaiOfBaocao != null) {
                    oldIDLoaiOfBaocao.setBaocao(null);
                    oldIDLoaiOfBaocao = em.merge(oldIDLoaiOfBaocao);
                }
                baocaoNew.setIDLoai(loaibaocao);
                baocaoNew = em.merge(baocaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = loaibaocao.getId();
                if (findLoaibaocao(id) == null) {
                    throw new NonexistentEntityException("The loaibaocao with id " + id + " no longer exists.");
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
            Loaibaocao loaibaocao;
            try {
                loaibaocao = em.getReference(Loaibaocao.class, id);
                loaibaocao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loaibaocao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Baocao baocaoOrphanCheck = loaibaocao.getBaocao();
            if (baocaoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Loaibaocao (" + loaibaocao + ") cannot be destroyed since the Baocao " + baocaoOrphanCheck + " in its baocao field has a non-nullable IDLoai field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(loaibaocao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Loaibaocao> findLoaibaocaoEntities() {
        return findLoaibaocaoEntities(true, -1, -1);
    }

    public List<Loaibaocao> findLoaibaocaoEntities(int maxResults, int firstResult) {
        return findLoaibaocaoEntities(false, maxResults, firstResult);
    }

    private List<Loaibaocao> findLoaibaocaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Loaibaocao.class));
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

    public Loaibaocao findLoaibaocao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Loaibaocao.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoaibaocaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Loaibaocao> rt = cq.from(Loaibaocao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
