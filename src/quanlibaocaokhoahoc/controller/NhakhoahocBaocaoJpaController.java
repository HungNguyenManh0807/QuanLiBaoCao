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
import quanlibaocaokhoahoc.Model.Vaitro;
import quanlibaocaokhoahoc.Model.Baocao;
import quanlibaocaokhoahoc.Model.Nhakhoahoc;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Model.NhakhoahocBaocao;
import quanlibaocaokhoahoc.Model.NhakhoahocBaocaoPK;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.exceptions.PreexistingEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class NhakhoahocBaocaoJpaController implements Serializable {

    public NhakhoahocBaocaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NhakhoahocBaocao nhakhoahocBaocao) throws PreexistingEntityException, Exception {
        if (nhakhoahocBaocao.getNhakhoahocBaocaoPK() == null) {
            nhakhoahocBaocao.setNhakhoahocBaocaoPK(new NhakhoahocBaocaoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vaitro IDVaiTro = nhakhoahocBaocao.getIDVaiTro();
            if (IDVaiTro != null) {
                IDVaiTro = em.getReference(IDVaiTro.getClass(), IDVaiTro.getId());
                nhakhoahocBaocao.setIDVaiTro(IDVaiTro);
            }
            Baocao baocao = nhakhoahocBaocao.getBaocao();
            if (baocao != null) {
                baocao = em.getReference(baocao.getClass(), baocao.getId());
                nhakhoahocBaocao.setBaocao(baocao);
            }
            Nhakhoahoc nhakhoahoc = nhakhoahocBaocao.getNhakhoahoc();
            if (nhakhoahoc != null) {
                nhakhoahoc = em.getReference(nhakhoahoc.getClass(), nhakhoahoc.getId());
                nhakhoahocBaocao.setNhakhoahoc(nhakhoahoc);
            }
            em.persist(nhakhoahocBaocao);
            if (IDVaiTro != null) {
                IDVaiTro.getNhakhoahocBaocaoCollection().add(nhakhoahocBaocao);
                IDVaiTro = em.merge(IDVaiTro);
            }
            if (baocao != null) {
                NhakhoahocBaocao oldNhakhoahocBaocaoOfBaocao = baocao.getNhakhoahocBaocao();
                if (oldNhakhoahocBaocaoOfBaocao != null) {
                    oldNhakhoahocBaocaoOfBaocao.setBaocao(null);
                    oldNhakhoahocBaocaoOfBaocao = em.merge(oldNhakhoahocBaocaoOfBaocao);
                }
                baocao.setNhakhoahocBaocao(nhakhoahocBaocao);
                baocao = em.merge(baocao);
            }
            if (nhakhoahoc != null) {
                NhakhoahocBaocao oldNhakhoahocBaocaoOfNhakhoahoc = nhakhoahoc.getNhakhoahocBaocao();
                if (oldNhakhoahocBaocaoOfNhakhoahoc != null) {
                    oldNhakhoahocBaocaoOfNhakhoahoc.setNhakhoahoc(null);
                    oldNhakhoahocBaocaoOfNhakhoahoc = em.merge(oldNhakhoahocBaocaoOfNhakhoahoc);
                }
                nhakhoahoc.setNhakhoahocBaocao(nhakhoahocBaocao);
                nhakhoahoc = em.merge(nhakhoahoc);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNhakhoahocBaocao(nhakhoahocBaocao.getNhakhoahocBaocaoPK()) != null) {
                throw new PreexistingEntityException("NhakhoahocBaocao " + nhakhoahocBaocao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NhakhoahocBaocao nhakhoahocBaocao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NhakhoahocBaocao persistentNhakhoahocBaocao = em.find(NhakhoahocBaocao.class, nhakhoahocBaocao.getNhakhoahocBaocaoPK());
            Vaitro IDVaiTroOld = persistentNhakhoahocBaocao.getIDVaiTro();
            Vaitro IDVaiTroNew = nhakhoahocBaocao.getIDVaiTro();
            Baocao baocaoOld = persistentNhakhoahocBaocao.getBaocao();
            Baocao baocaoNew = nhakhoahocBaocao.getBaocao();
            Nhakhoahoc nhakhoahocOld = persistentNhakhoahocBaocao.getNhakhoahoc();
            Nhakhoahoc nhakhoahocNew = nhakhoahocBaocao.getNhakhoahoc();
            List<String> illegalOrphanMessages = null;
            if (baocaoOld != null && !baocaoOld.equals(baocaoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Baocao " + baocaoOld + " since its nhakhoahocBaocao field is not nullable.");
            }
            if (nhakhoahocOld != null && !nhakhoahocOld.equals(nhakhoahocNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Nhakhoahoc " + nhakhoahocOld + " since its nhakhoahocBaocao field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (IDVaiTroNew != null) {
                IDVaiTroNew = em.getReference(IDVaiTroNew.getClass(), IDVaiTroNew.getId());
                nhakhoahocBaocao.setIDVaiTro(IDVaiTroNew);
            }
            if (baocaoNew != null) {
                baocaoNew = em.getReference(baocaoNew.getClass(), baocaoNew.getId());
                nhakhoahocBaocao.setBaocao(baocaoNew);
            }
            if (nhakhoahocNew != null) {
                nhakhoahocNew = em.getReference(nhakhoahocNew.getClass(), nhakhoahocNew.getId());
                nhakhoahocBaocao.setNhakhoahoc(nhakhoahocNew);
            }
            nhakhoahocBaocao = em.merge(nhakhoahocBaocao);
            if (IDVaiTroOld != null && !IDVaiTroOld.equals(IDVaiTroNew)) {
                IDVaiTroOld.getNhakhoahocBaocaoCollection().remove(nhakhoahocBaocao);
                IDVaiTroOld = em.merge(IDVaiTroOld);
            }
            if (IDVaiTroNew != null && !IDVaiTroNew.equals(IDVaiTroOld)) {
                IDVaiTroNew.getNhakhoahocBaocaoCollection().add(nhakhoahocBaocao);
                IDVaiTroNew = em.merge(IDVaiTroNew);
            }
            if (baocaoNew != null && !baocaoNew.equals(baocaoOld)) {
                NhakhoahocBaocao oldNhakhoahocBaocaoOfBaocao = baocaoNew.getNhakhoahocBaocao();
                if (oldNhakhoahocBaocaoOfBaocao != null) {
                    oldNhakhoahocBaocaoOfBaocao.setBaocao(null);
                    oldNhakhoahocBaocaoOfBaocao = em.merge(oldNhakhoahocBaocaoOfBaocao);
                }
                baocaoNew.setNhakhoahocBaocao(nhakhoahocBaocao);
                baocaoNew = em.merge(baocaoNew);
            }
            if (nhakhoahocNew != null && !nhakhoahocNew.equals(nhakhoahocOld)) {
                NhakhoahocBaocao oldNhakhoahocBaocaoOfNhakhoahoc = nhakhoahocNew.getNhakhoahocBaocao();
                if (oldNhakhoahocBaocaoOfNhakhoahoc != null) {
                    oldNhakhoahocBaocaoOfNhakhoahoc.setNhakhoahoc(null);
                    oldNhakhoahocBaocaoOfNhakhoahoc = em.merge(oldNhakhoahocBaocaoOfNhakhoahoc);
                }
                nhakhoahocNew.setNhakhoahocBaocao(nhakhoahocBaocao);
                nhakhoahocNew = em.merge(nhakhoahocNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                NhakhoahocBaocaoPK id = nhakhoahocBaocao.getNhakhoahocBaocaoPK();
                if (findNhakhoahocBaocao(id) == null) {
                    throw new NonexistentEntityException("The nhakhoahocBaocao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(NhakhoahocBaocaoPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NhakhoahocBaocao nhakhoahocBaocao;
            try {
                nhakhoahocBaocao = em.getReference(NhakhoahocBaocao.class, id);
                nhakhoahocBaocao.getNhakhoahocBaocaoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nhakhoahocBaocao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Baocao baocaoOrphanCheck = nhakhoahocBaocao.getBaocao();
            if (baocaoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This NhakhoahocBaocao (" + nhakhoahocBaocao + ") cannot be destroyed since the Baocao " + baocaoOrphanCheck + " in its baocao field has a non-nullable nhakhoahocBaocao field.");
            }
            Nhakhoahoc nhakhoahocOrphanCheck = nhakhoahocBaocao.getNhakhoahoc();
            if (nhakhoahocOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This NhakhoahocBaocao (" + nhakhoahocBaocao + ") cannot be destroyed since the Nhakhoahoc " + nhakhoahocOrphanCheck + " in its nhakhoahoc field has a non-nullable nhakhoahocBaocao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Vaitro IDVaiTro = nhakhoahocBaocao.getIDVaiTro();
            if (IDVaiTro != null) {
                IDVaiTro.getNhakhoahocBaocaoCollection().remove(nhakhoahocBaocao);
                IDVaiTro = em.merge(IDVaiTro);
            }
            em.remove(nhakhoahocBaocao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NhakhoahocBaocao> findNhakhoahocBaocaoEntities() {
        return findNhakhoahocBaocaoEntities(true, -1, -1);
    }

    public List<NhakhoahocBaocao> findNhakhoahocBaocaoEntities(int maxResults, int firstResult) {
        return findNhakhoahocBaocaoEntities(false, maxResults, firstResult);
    }

    private List<NhakhoahocBaocao> findNhakhoahocBaocaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NhakhoahocBaocao.class));
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

    public NhakhoahocBaocao findNhakhoahocBaocao(NhakhoahocBaocaoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NhakhoahocBaocao.class, id);
        } finally {
            em.close();
        }
    }

    public int getNhakhoahocBaocaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NhakhoahocBaocao> rt = cq.from(NhakhoahocBaocao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
