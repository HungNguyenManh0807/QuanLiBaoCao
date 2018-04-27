/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlibaocaokhoahoc.Controller;

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
import quanlibaocaokhoahoc.Controller.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.Model.Linhvuc;

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
        if (linhvuc.getBaocaoList() == null) {
            linhvuc.setBaocaoList(new ArrayList<Baocao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Baocao> attachedBaocaoList = new ArrayList<Baocao>();
            for (Baocao baocaoListBaocaoToAttach : linhvuc.getBaocaoList()) {
                baocaoListBaocaoToAttach = em.getReference(baocaoListBaocaoToAttach.getClass(), baocaoListBaocaoToAttach.getId());
                attachedBaocaoList.add(baocaoListBaocaoToAttach);
            }
            linhvuc.setBaocaoList(attachedBaocaoList);
            em.persist(linhvuc);
            for (Baocao baocaoListBaocao : linhvuc.getBaocaoList()) {
                Linhvuc oldIDLinhVucOfBaocaoListBaocao = baocaoListBaocao.getIDLinhVuc();
                baocaoListBaocao.setIDLinhVuc(linhvuc);
                baocaoListBaocao = em.merge(baocaoListBaocao);
                if (oldIDLinhVucOfBaocaoListBaocao != null) {
                    oldIDLinhVucOfBaocaoListBaocao.getBaocaoList().remove(baocaoListBaocao);
                    oldIDLinhVucOfBaocaoListBaocao = em.merge(oldIDLinhVucOfBaocaoListBaocao);
                }
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
            Linhvuc persistentLinhvuc = em.find(Linhvuc.class, linhvuc.getId());
            List<Baocao> baocaoListOld = persistentLinhvuc.getBaocaoList();
            List<Baocao> baocaoListNew = linhvuc.getBaocaoList();
            List<String> illegalOrphanMessages = null;
            for (Baocao baocaoListOldBaocao : baocaoListOld) {
                if (!baocaoListNew.contains(baocaoListOldBaocao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Baocao " + baocaoListOldBaocao + " since its IDLinhVuc field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Baocao> attachedBaocaoListNew = new ArrayList<Baocao>();
            for (Baocao baocaoListNewBaocaoToAttach : baocaoListNew) {
                baocaoListNewBaocaoToAttach = em.getReference(baocaoListNewBaocaoToAttach.getClass(), baocaoListNewBaocaoToAttach.getId());
                attachedBaocaoListNew.add(baocaoListNewBaocaoToAttach);
            }
            baocaoListNew = attachedBaocaoListNew;
            linhvuc.setBaocaoList(baocaoListNew);
            linhvuc = em.merge(linhvuc);
            for (Baocao baocaoListNewBaocao : baocaoListNew) {
                if (!baocaoListOld.contains(baocaoListNewBaocao)) {
                    Linhvuc oldIDLinhVucOfBaocaoListNewBaocao = baocaoListNewBaocao.getIDLinhVuc();
                    baocaoListNewBaocao.setIDLinhVuc(linhvuc);
                    baocaoListNewBaocao = em.merge(baocaoListNewBaocao);
                    if (oldIDLinhVucOfBaocaoListNewBaocao != null && !oldIDLinhVucOfBaocaoListNewBaocao.equals(linhvuc)) {
                        oldIDLinhVucOfBaocaoListNewBaocao.getBaocaoList().remove(baocaoListNewBaocao);
                        oldIDLinhVucOfBaocaoListNewBaocao = em.merge(oldIDLinhVucOfBaocaoListNewBaocao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = linhvuc.getId();
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
                linhvuc.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The linhvuc with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Baocao> baocaoListOrphanCheck = linhvuc.getBaocaoList();
            for (Baocao baocaoListOrphanCheckBaocao : baocaoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Linhvuc (" + linhvuc + ") cannot be destroyed since the Baocao " + baocaoListOrphanCheckBaocao + " in its baocaoList field has a non-nullable IDLinhVuc field.");
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
