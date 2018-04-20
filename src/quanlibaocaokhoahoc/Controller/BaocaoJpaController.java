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
import quanlibaocaokhoahoc.Model.Linhvuc;
import quanlibaocaokhoahoc.Model.Loaibaocao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Controller.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.Model.Baocao;

/**
 *
 * @author Hung Nguyen
 */
public class BaocaoJpaController implements Serializable {

    public BaocaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Baocao baocao) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Linhvuc IDLinhVucOrphanCheck = baocao.getIDLinhVuc();
        if (IDLinhVucOrphanCheck != null) {
            Baocao oldBaocaoOfIDLinhVuc = IDLinhVucOrphanCheck.getBaocao();
            if (oldBaocaoOfIDLinhVuc != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Linhvuc " + IDLinhVucOrphanCheck + " already has an item of type Baocao whose IDLinhVuc column cannot be null. Please make another selection for the IDLinhVuc field.");
            }
        }
        Loaibaocao IDLoaiOrphanCheck = baocao.getIDLoai();
        if (IDLoaiOrphanCheck != null) {
            Baocao oldBaocaoOfIDLoai = IDLoaiOrphanCheck.getBaocao();
            if (oldBaocaoOfIDLoai != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Loaibaocao " + IDLoaiOrphanCheck + " already has an item of type Baocao whose IDLoai column cannot be null. Please make another selection for the IDLoai field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Linhvuc IDLinhVuc = baocao.getIDLinhVuc();
            if (IDLinhVuc != null) {
                IDLinhVuc = em.getReference(IDLinhVuc.getClass(), IDLinhVuc.getId());
                baocao.setIDLinhVuc(IDLinhVuc);
            }
            Loaibaocao IDLoai = baocao.getIDLoai();
            if (IDLoai != null) {
                IDLoai = em.getReference(IDLoai.getClass(), IDLoai.getId());
                baocao.setIDLoai(IDLoai);
            }
            em.persist(baocao);
            if (IDLinhVuc != null) {
                IDLinhVuc.setBaocao(baocao);
                IDLinhVuc = em.merge(IDLinhVuc);
            }
            if (IDLoai != null) {
                IDLoai.setBaocao(baocao);
                IDLoai = em.merge(IDLoai);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Baocao baocao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Baocao persistentBaocao = em.find(Baocao.class, baocao.getId());
            Linhvuc IDLinhVucOld = persistentBaocao.getIDLinhVuc();
            Linhvuc IDLinhVucNew = baocao.getIDLinhVuc();
            Loaibaocao IDLoaiOld = persistentBaocao.getIDLoai();
            Loaibaocao IDLoaiNew = baocao.getIDLoai();
            List<String> illegalOrphanMessages = null;
            if (IDLinhVucNew != null && !IDLinhVucNew.equals(IDLinhVucOld)) {
                Baocao oldBaocaoOfIDLinhVuc = IDLinhVucNew.getBaocao();
                if (oldBaocaoOfIDLinhVuc != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Linhvuc " + IDLinhVucNew + " already has an item of type Baocao whose IDLinhVuc column cannot be null. Please make another selection for the IDLinhVuc field.");
                }
            }
            if (IDLoaiNew != null && !IDLoaiNew.equals(IDLoaiOld)) {
                Baocao oldBaocaoOfIDLoai = IDLoaiNew.getBaocao();
                if (oldBaocaoOfIDLoai != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Loaibaocao " + IDLoaiNew + " already has an item of type Baocao whose IDLoai column cannot be null. Please make another selection for the IDLoai field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (IDLinhVucNew != null) {
                IDLinhVucNew = em.getReference(IDLinhVucNew.getClass(), IDLinhVucNew.getId());
                baocao.setIDLinhVuc(IDLinhVucNew);
            }
            if (IDLoaiNew != null) {
                IDLoaiNew = em.getReference(IDLoaiNew.getClass(), IDLoaiNew.getId());
                baocao.setIDLoai(IDLoaiNew);
            }
            baocao = em.merge(baocao);
            if (IDLinhVucOld != null && !IDLinhVucOld.equals(IDLinhVucNew)) {
                IDLinhVucOld.setBaocao(null);
                IDLinhVucOld = em.merge(IDLinhVucOld);
            }
            if (IDLinhVucNew != null && !IDLinhVucNew.equals(IDLinhVucOld)) {
                IDLinhVucNew.setBaocao(baocao);
                IDLinhVucNew = em.merge(IDLinhVucNew);
            }
            if (IDLoaiOld != null && !IDLoaiOld.equals(IDLoaiNew)) {
                IDLoaiOld.setBaocao(null);
                IDLoaiOld = em.merge(IDLoaiOld);
            }
            if (IDLoaiNew != null && !IDLoaiNew.equals(IDLoaiOld)) {
                IDLoaiNew.setBaocao(baocao);
                IDLoaiNew = em.merge(IDLoaiNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = baocao.getId();
                if (findBaocao(id) == null) {
                    throw new NonexistentEntityException("The baocao with id " + id + " no longer exists.");
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
            Baocao baocao;
            try {
                baocao = em.getReference(Baocao.class, id);
                baocao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The baocao with id " + id + " no longer exists.", enfe);
            }
            Linhvuc IDLinhVuc = baocao.getIDLinhVuc();
            if (IDLinhVuc != null) {
                IDLinhVuc.setBaocao(null);
                IDLinhVuc = em.merge(IDLinhVuc);
            }
            Loaibaocao IDLoai = baocao.getIDLoai();
            if (IDLoai != null) {
                IDLoai.setBaocao(null);
                IDLoai = em.merge(IDLoai);
            }
            em.remove(baocao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Baocao> findBaocaoEntities() {
        return findBaocaoEntities(true, -1, -1);
    }

    public List<Baocao> findBaocaoEntities(int maxResults, int firstResult) {
        return findBaocaoEntities(false, maxResults, firstResult);
    }

    private List<Baocao> findBaocaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Baocao.class));
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

    public Baocao findBaocao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Baocao.class, id);
        } finally {
            em.close();
        }
    }

    public int getBaocaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Baocao> rt = cq.from(Baocao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}