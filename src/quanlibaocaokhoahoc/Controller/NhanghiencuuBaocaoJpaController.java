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
import quanlibaocaokhoahoc.Controller.exceptions.PreexistingEntityException;
import quanlibaocaokhoahoc.Model.Baocao;
import quanlibaocaokhoahoc.Model.Nhanghiencuu;
import quanlibaocaokhoahoc.Model.NhanghiencuuBaocao;
import quanlibaocaokhoahoc.Model.NhanghiencuuBaocaoPK;
import quanlibaocaokhoahoc.Model.Vaitro;

/**
 *
 * @author Hung Nguyen
 */
public class NhanghiencuuBaocaoJpaController implements Serializable {

    public NhanghiencuuBaocaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NhanghiencuuBaocao nhanghiencuuBaocao) throws PreexistingEntityException, Exception {
        if (nhanghiencuuBaocao.getNhanghiencuuBaocaoPK() == null) {
            nhanghiencuuBaocao.setNhanghiencuuBaocaoPK(new NhanghiencuuBaocaoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Baocao baocao = nhanghiencuuBaocao.getBaocao();
            if (baocao != null) {
                baocao = em.getReference(baocao.getClass(), baocao.getId());
                nhanghiencuuBaocao.setBaocao(baocao);
            }
            Nhanghiencuu nhanghiencuu = nhanghiencuuBaocao.getNhanghiencuu();
            if (nhanghiencuu != null) {
                nhanghiencuu = em.getReference(nhanghiencuu.getClass(), nhanghiencuu.getId());
                nhanghiencuuBaocao.setNhanghiencuu(nhanghiencuu);
            }
            Vaitro IDVaiTro = nhanghiencuuBaocao.getIDVaiTro();
            if (IDVaiTro != null) {
                IDVaiTro = em.getReference(IDVaiTro.getClass(), IDVaiTro.getId());
                nhanghiencuuBaocao.setIDVaiTro(IDVaiTro);
            }
            em.persist(nhanghiencuuBaocao);
            if (baocao != null) {
                baocao.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                baocao = em.merge(baocao);
            }
            if (nhanghiencuu != null) {
                nhanghiencuu.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                nhanghiencuu = em.merge(nhanghiencuu);
            }
            if (IDVaiTro != null) {
                IDVaiTro.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                IDVaiTro = em.merge(IDVaiTro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNhanghiencuuBaocao(nhanghiencuuBaocao.getNhanghiencuuBaocaoPK()) != null) {
                throw new PreexistingEntityException("NhanghiencuuBaocao " + nhanghiencuuBaocao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NhanghiencuuBaocao nhanghiencuuBaocao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NhanghiencuuBaocao persistentNhanghiencuuBaocao = em.find(NhanghiencuuBaocao.class, nhanghiencuuBaocao.getNhanghiencuuBaocaoPK());
            Baocao baocaoOld = persistentNhanghiencuuBaocao.getBaocao();
            Baocao baocaoNew = nhanghiencuuBaocao.getBaocao();
            Nhanghiencuu nhanghiencuuOld = persistentNhanghiencuuBaocao.getNhanghiencuu();
            Nhanghiencuu nhanghiencuuNew = nhanghiencuuBaocao.getNhanghiencuu();
            Vaitro IDVaiTroOld = persistentNhanghiencuuBaocao.getIDVaiTro();
            Vaitro IDVaiTroNew = nhanghiencuuBaocao.getIDVaiTro();
            if (baocaoNew != null) {
                baocaoNew = em.getReference(baocaoNew.getClass(), baocaoNew.getId());
                nhanghiencuuBaocao.setBaocao(baocaoNew);
            }
            if (nhanghiencuuNew != null) {
                nhanghiencuuNew = em.getReference(nhanghiencuuNew.getClass(), nhanghiencuuNew.getId());
                nhanghiencuuBaocao.setNhanghiencuu(nhanghiencuuNew);
            }
            if (IDVaiTroNew != null) {
                IDVaiTroNew = em.getReference(IDVaiTroNew.getClass(), IDVaiTroNew.getId());
                nhanghiencuuBaocao.setIDVaiTro(IDVaiTroNew);
            }
            nhanghiencuuBaocao = em.merge(nhanghiencuuBaocao);
            if (baocaoOld != null && !baocaoOld.equals(baocaoNew)) {
                baocaoOld.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                baocaoOld = em.merge(baocaoOld);
            }
            if (baocaoNew != null && !baocaoNew.equals(baocaoOld)) {
                baocaoNew.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                baocaoNew = em.merge(baocaoNew);
            }
            if (nhanghiencuuOld != null && !nhanghiencuuOld.equals(nhanghiencuuNew)) {
                nhanghiencuuOld.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                nhanghiencuuOld = em.merge(nhanghiencuuOld);
            }
            if (nhanghiencuuNew != null && !nhanghiencuuNew.equals(nhanghiencuuOld)) {
                nhanghiencuuNew.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                nhanghiencuuNew = em.merge(nhanghiencuuNew);
            }
            if (IDVaiTroOld != null && !IDVaiTroOld.equals(IDVaiTroNew)) {
                IDVaiTroOld.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                IDVaiTroOld = em.merge(IDVaiTroOld);
            }
            if (IDVaiTroNew != null && !IDVaiTroNew.equals(IDVaiTroOld)) {
                IDVaiTroNew.getNhanghiencuuBaocaoList().add(nhanghiencuuBaocao);
                IDVaiTroNew = em.merge(IDVaiTroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                NhanghiencuuBaocaoPK id = nhanghiencuuBaocao.getNhanghiencuuBaocaoPK();
                if (findNhanghiencuuBaocao(id) == null) {
                    throw new NonexistentEntityException("The nhanghiencuuBaocao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(NhanghiencuuBaocaoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NhanghiencuuBaocao nhanghiencuuBaocao;
            try {
                nhanghiencuuBaocao = em.getReference(NhanghiencuuBaocao.class, id);
                nhanghiencuuBaocao.getNhanghiencuuBaocaoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nhanghiencuuBaocao with id " + id + " no longer exists.", enfe);
            }
            Baocao baocao = nhanghiencuuBaocao.getBaocao();
            if (baocao != null) {
                baocao.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                baocao = em.merge(baocao);
            }
            Nhanghiencuu nhanghiencuu = nhanghiencuuBaocao.getNhanghiencuu();
            if (nhanghiencuu != null) {
                nhanghiencuu.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                nhanghiencuu = em.merge(nhanghiencuu);
            }
            Vaitro IDVaiTro = nhanghiencuuBaocao.getIDVaiTro();
            if (IDVaiTro != null) {
                IDVaiTro.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocao);
                IDVaiTro = em.merge(IDVaiTro);
            }
            em.remove(nhanghiencuuBaocao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NhanghiencuuBaocao> findNhanghiencuuBaocaoEntities() {
        return findNhanghiencuuBaocaoEntities(true, -1, -1);
    }

    public List<NhanghiencuuBaocao> findNhanghiencuuBaocaoEntities(int maxResults, int firstResult) {
        return findNhanghiencuuBaocaoEntities(false, maxResults, firstResult);
    }

    private List<NhanghiencuuBaocao> findNhanghiencuuBaocaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NhanghiencuuBaocao.class));
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

    public NhanghiencuuBaocao findNhanghiencuuBaocao(NhanghiencuuBaocaoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NhanghiencuuBaocao.class, id);
        } finally {
            em.close();
        }
    }

    public int getNhanghiencuuBaocaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NhanghiencuuBaocao> rt = cq.from(NhanghiencuuBaocao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
