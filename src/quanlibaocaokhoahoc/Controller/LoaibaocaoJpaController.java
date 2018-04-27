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
import quanlibaocaokhoahoc.Model.Loaibaocao;

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
        if (loaibaocao.getBaocaoList() == null) {
            loaibaocao.setBaocaoList(new ArrayList<Baocao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Baocao> attachedBaocaoList = new ArrayList<Baocao>();
            for (Baocao baocaoListBaocaoToAttach : loaibaocao.getBaocaoList()) {
                baocaoListBaocaoToAttach = em.getReference(baocaoListBaocaoToAttach.getClass(), baocaoListBaocaoToAttach.getId());
                attachedBaocaoList.add(baocaoListBaocaoToAttach);
            }
            loaibaocao.setBaocaoList(attachedBaocaoList);
            em.persist(loaibaocao);
            for (Baocao baocaoListBaocao : loaibaocao.getBaocaoList()) {
                Loaibaocao oldIDLoaiOfBaocaoListBaocao = baocaoListBaocao.getIDLoai();
                baocaoListBaocao.setIDLoai(loaibaocao);
                baocaoListBaocao = em.merge(baocaoListBaocao);
                if (oldIDLoaiOfBaocaoListBaocao != null) {
                    oldIDLoaiOfBaocaoListBaocao.getBaocaoList().remove(baocaoListBaocao);
                    oldIDLoaiOfBaocaoListBaocao = em.merge(oldIDLoaiOfBaocaoListBaocao);
                }
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
            List<Baocao> baocaoListOld = persistentLoaibaocao.getBaocaoList();
            List<Baocao> baocaoListNew = loaibaocao.getBaocaoList();
            List<String> illegalOrphanMessages = null;
            for (Baocao baocaoListOldBaocao : baocaoListOld) {
                if (!baocaoListNew.contains(baocaoListOldBaocao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Baocao " + baocaoListOldBaocao + " since its IDLoai field is not nullable.");
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
            loaibaocao.setBaocaoList(baocaoListNew);
            loaibaocao = em.merge(loaibaocao);
            for (Baocao baocaoListNewBaocao : baocaoListNew) {
                if (!baocaoListOld.contains(baocaoListNewBaocao)) {
                    Loaibaocao oldIDLoaiOfBaocaoListNewBaocao = baocaoListNewBaocao.getIDLoai();
                    baocaoListNewBaocao.setIDLoai(loaibaocao);
                    baocaoListNewBaocao = em.merge(baocaoListNewBaocao);
                    if (oldIDLoaiOfBaocaoListNewBaocao != null && !oldIDLoaiOfBaocaoListNewBaocao.equals(loaibaocao)) {
                        oldIDLoaiOfBaocaoListNewBaocao.getBaocaoList().remove(baocaoListNewBaocao);
                        oldIDLoaiOfBaocaoListNewBaocao = em.merge(oldIDLoaiOfBaocaoListNewBaocao);
                    }
                }
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
            List<Baocao> baocaoListOrphanCheck = loaibaocao.getBaocaoList();
            for (Baocao baocaoListOrphanCheckBaocao : baocaoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Loaibaocao (" + loaibaocao + ") cannot be destroyed since the Baocao " + baocaoListOrphanCheckBaocao + " in its baocaoList field has a non-nullable IDLoai field.");
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
