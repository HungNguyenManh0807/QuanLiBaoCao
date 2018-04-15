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
import quanlibaocaokhoahoc.Model.NhakhoahocBaocao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Model.Vaitro;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.exceptions.PreexistingEntityException;

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

    public void create(Vaitro vaitro) throws PreexistingEntityException, Exception {
        if (vaitro.getNhakhoahocBaocaoCollection() == null) {
            vaitro.setNhakhoahocBaocaoCollection(new ArrayList<NhakhoahocBaocao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<NhakhoahocBaocao> attachedNhakhoahocBaocaoCollection = new ArrayList<NhakhoahocBaocao>();
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionNhakhoahocBaocaoToAttach : vaitro.getNhakhoahocBaocaoCollection()) {
                nhakhoahocBaocaoCollectionNhakhoahocBaocaoToAttach = em.getReference(nhakhoahocBaocaoCollectionNhakhoahocBaocaoToAttach.getClass(), nhakhoahocBaocaoCollectionNhakhoahocBaocaoToAttach.getNhakhoahocBaocaoPK());
                attachedNhakhoahocBaocaoCollection.add(nhakhoahocBaocaoCollectionNhakhoahocBaocaoToAttach);
            }
            vaitro.setNhakhoahocBaocaoCollection(attachedNhakhoahocBaocaoCollection);
            em.persist(vaitro);
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionNhakhoahocBaocao : vaitro.getNhakhoahocBaocaoCollection()) {
                Vaitro oldIDVaiTroOfNhakhoahocBaocaoCollectionNhakhoahocBaocao = nhakhoahocBaocaoCollectionNhakhoahocBaocao.getIDVaiTro();
                nhakhoahocBaocaoCollectionNhakhoahocBaocao.setIDVaiTro(vaitro);
                nhakhoahocBaocaoCollectionNhakhoahocBaocao = em.merge(nhakhoahocBaocaoCollectionNhakhoahocBaocao);
                if (oldIDVaiTroOfNhakhoahocBaocaoCollectionNhakhoahocBaocao != null) {
                    oldIDVaiTroOfNhakhoahocBaocaoCollectionNhakhoahocBaocao.getNhakhoahocBaocaoCollection().remove(nhakhoahocBaocaoCollectionNhakhoahocBaocao);
                    oldIDVaiTroOfNhakhoahocBaocaoCollectionNhakhoahocBaocao = em.merge(oldIDVaiTroOfNhakhoahocBaocaoCollectionNhakhoahocBaocao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVaitro(vaitro.getId()) != null) {
                throw new PreexistingEntityException("Vaitro " + vaitro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vaitro vaitro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vaitro persistentVaitro = em.find(Vaitro.class, vaitro.getId());
            Collection<NhakhoahocBaocao> nhakhoahocBaocaoCollectionOld = persistentVaitro.getNhakhoahocBaocaoCollection();
            Collection<NhakhoahocBaocao> nhakhoahocBaocaoCollectionNew = vaitro.getNhakhoahocBaocaoCollection();
            List<String> illegalOrphanMessages = null;
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionOldNhakhoahocBaocao : nhakhoahocBaocaoCollectionOld) {
                if (!nhakhoahocBaocaoCollectionNew.contains(nhakhoahocBaocaoCollectionOldNhakhoahocBaocao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain NhakhoahocBaocao " + nhakhoahocBaocaoCollectionOldNhakhoahocBaocao + " since its IDVaiTro field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<NhakhoahocBaocao> attachedNhakhoahocBaocaoCollectionNew = new ArrayList<NhakhoahocBaocao>();
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionNewNhakhoahocBaocaoToAttach : nhakhoahocBaocaoCollectionNew) {
                nhakhoahocBaocaoCollectionNewNhakhoahocBaocaoToAttach = em.getReference(nhakhoahocBaocaoCollectionNewNhakhoahocBaocaoToAttach.getClass(), nhakhoahocBaocaoCollectionNewNhakhoahocBaocaoToAttach.getNhakhoahocBaocaoPK());
                attachedNhakhoahocBaocaoCollectionNew.add(nhakhoahocBaocaoCollectionNewNhakhoahocBaocaoToAttach);
            }
            nhakhoahocBaocaoCollectionNew = attachedNhakhoahocBaocaoCollectionNew;
            vaitro.setNhakhoahocBaocaoCollection(nhakhoahocBaocaoCollectionNew);
            vaitro = em.merge(vaitro);
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionNewNhakhoahocBaocao : nhakhoahocBaocaoCollectionNew) {
                if (!nhakhoahocBaocaoCollectionOld.contains(nhakhoahocBaocaoCollectionNewNhakhoahocBaocao)) {
                    Vaitro oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao = nhakhoahocBaocaoCollectionNewNhakhoahocBaocao.getIDVaiTro();
                    nhakhoahocBaocaoCollectionNewNhakhoahocBaocao.setIDVaiTro(vaitro);
                    nhakhoahocBaocaoCollectionNewNhakhoahocBaocao = em.merge(nhakhoahocBaocaoCollectionNewNhakhoahocBaocao);
                    if (oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao != null && !oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao.equals(vaitro)) {
                        oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao.getNhakhoahocBaocaoCollection().remove(nhakhoahocBaocaoCollectionNewNhakhoahocBaocao);
                        oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao = em.merge(oldIDVaiTroOfNhakhoahocBaocaoCollectionNewNhakhoahocBaocao);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<NhakhoahocBaocao> nhakhoahocBaocaoCollectionOrphanCheck = vaitro.getNhakhoahocBaocaoCollection();
            for (NhakhoahocBaocao nhakhoahocBaocaoCollectionOrphanCheckNhakhoahocBaocao : nhakhoahocBaocaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vaitro (" + vaitro + ") cannot be destroyed since the NhakhoahocBaocao " + nhakhoahocBaocaoCollectionOrphanCheckNhakhoahocBaocao + " in its nhakhoahocBaocaoCollection field has a non-nullable IDVaiTro field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
