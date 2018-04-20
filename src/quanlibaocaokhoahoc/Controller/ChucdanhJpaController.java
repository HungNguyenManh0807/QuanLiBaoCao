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
import quanlibaocaokhoahoc.Model.Nhanghiencuu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Controller.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.Model.Chucdanh;

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
        if (chucdanh.getNhanghiencuuList() == null) {
            chucdanh.setNhanghiencuuList(new ArrayList<Nhanghiencuu>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Nhanghiencuu> attachedNhanghiencuuList = new ArrayList<Nhanghiencuu>();
            for (Nhanghiencuu nhanghiencuuListNhanghiencuuToAttach : chucdanh.getNhanghiencuuList()) {
                nhanghiencuuListNhanghiencuuToAttach = em.getReference(nhanghiencuuListNhanghiencuuToAttach.getClass(), nhanghiencuuListNhanghiencuuToAttach.getId());
                attachedNhanghiencuuList.add(nhanghiencuuListNhanghiencuuToAttach);
            }
            chucdanh.setNhanghiencuuList(attachedNhanghiencuuList);
            em.persist(chucdanh);
            for (Nhanghiencuu nhanghiencuuListNhanghiencuu : chucdanh.getNhanghiencuuList()) {
                Chucdanh oldIDChucDanhOfNhanghiencuuListNhanghiencuu = nhanghiencuuListNhanghiencuu.getIDChucDanh();
                nhanghiencuuListNhanghiencuu.setIDChucDanh(chucdanh);
                nhanghiencuuListNhanghiencuu = em.merge(nhanghiencuuListNhanghiencuu);
                if (oldIDChucDanhOfNhanghiencuuListNhanghiencuu != null) {
                    oldIDChucDanhOfNhanghiencuuListNhanghiencuu.getNhanghiencuuList().remove(nhanghiencuuListNhanghiencuu);
                    oldIDChucDanhOfNhanghiencuuListNhanghiencuu = em.merge(oldIDChucDanhOfNhanghiencuuListNhanghiencuu);
                }
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
            List<Nhanghiencuu> nhanghiencuuListOld = persistentChucdanh.getNhanghiencuuList();
            List<Nhanghiencuu> nhanghiencuuListNew = chucdanh.getNhanghiencuuList();
            List<String> illegalOrphanMessages = null;
            for (Nhanghiencuu nhanghiencuuListOldNhanghiencuu : nhanghiencuuListOld) {
                if (!nhanghiencuuListNew.contains(nhanghiencuuListOldNhanghiencuu)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nhanghiencuu " + nhanghiencuuListOldNhanghiencuu + " since its IDChucDanh field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Nhanghiencuu> attachedNhanghiencuuListNew = new ArrayList<Nhanghiencuu>();
            for (Nhanghiencuu nhanghiencuuListNewNhanghiencuuToAttach : nhanghiencuuListNew) {
                nhanghiencuuListNewNhanghiencuuToAttach = em.getReference(nhanghiencuuListNewNhanghiencuuToAttach.getClass(), nhanghiencuuListNewNhanghiencuuToAttach.getId());
                attachedNhanghiencuuListNew.add(nhanghiencuuListNewNhanghiencuuToAttach);
            }
            nhanghiencuuListNew = attachedNhanghiencuuListNew;
            chucdanh.setNhanghiencuuList(nhanghiencuuListNew);
            chucdanh = em.merge(chucdanh);
            for (Nhanghiencuu nhanghiencuuListNewNhanghiencuu : nhanghiencuuListNew) {
                if (!nhanghiencuuListOld.contains(nhanghiencuuListNewNhanghiencuu)) {
                    Chucdanh oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu = nhanghiencuuListNewNhanghiencuu.getIDChucDanh();
                    nhanghiencuuListNewNhanghiencuu.setIDChucDanh(chucdanh);
                    nhanghiencuuListNewNhanghiencuu = em.merge(nhanghiencuuListNewNhanghiencuu);
                    if (oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu != null && !oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu.equals(chucdanh)) {
                        oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu.getNhanghiencuuList().remove(nhanghiencuuListNewNhanghiencuu);
                        oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu = em.merge(oldIDChucDanhOfNhanghiencuuListNewNhanghiencuu);
                    }
                }
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
            List<Nhanghiencuu> nhanghiencuuListOrphanCheck = chucdanh.getNhanghiencuuList();
            for (Nhanghiencuu nhanghiencuuListOrphanCheckNhanghiencuu : nhanghiencuuListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Chucdanh (" + chucdanh + ") cannot be destroyed since the Nhanghiencuu " + nhanghiencuuListOrphanCheckNhanghiencuu + " in its nhanghiencuuList field has a non-nullable IDChucDanh field.");
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
