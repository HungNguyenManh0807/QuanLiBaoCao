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
import quanlibaocaokhoahoc.Model.Coquan;

/**
 *
 * @author Hung Nguyen
 */
public class CoquanJpaController implements Serializable {

    public CoquanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Coquan coquan) {
        if (coquan.getNhanghiencuuList() == null) {
            coquan.setNhanghiencuuList(new ArrayList<Nhanghiencuu>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Nhanghiencuu> attachedNhanghiencuuList = new ArrayList<Nhanghiencuu>();
            for (Nhanghiencuu nhanghiencuuListNhanghiencuuToAttach : coquan.getNhanghiencuuList()) {
                nhanghiencuuListNhanghiencuuToAttach = em.getReference(nhanghiencuuListNhanghiencuuToAttach.getClass(), nhanghiencuuListNhanghiencuuToAttach.getId());
                attachedNhanghiencuuList.add(nhanghiencuuListNhanghiencuuToAttach);
            }
            coquan.setNhanghiencuuList(attachedNhanghiencuuList);
            em.persist(coquan);
            for (Nhanghiencuu nhanghiencuuListNhanghiencuu : coquan.getNhanghiencuuList()) {
                Coquan oldIDCoQuanOfNhanghiencuuListNhanghiencuu = nhanghiencuuListNhanghiencuu.getIDCoQuan();
                nhanghiencuuListNhanghiencuu.setIDCoQuan(coquan);
                nhanghiencuuListNhanghiencuu = em.merge(nhanghiencuuListNhanghiencuu);
                if (oldIDCoQuanOfNhanghiencuuListNhanghiencuu != null) {
                    oldIDCoQuanOfNhanghiencuuListNhanghiencuu.getNhanghiencuuList().remove(nhanghiencuuListNhanghiencuu);
                    oldIDCoQuanOfNhanghiencuuListNhanghiencuu = em.merge(oldIDCoQuanOfNhanghiencuuListNhanghiencuu);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Coquan coquan) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Coquan persistentCoquan = em.find(Coquan.class, coquan.getId());
            List<Nhanghiencuu> nhanghiencuuListOld = persistentCoquan.getNhanghiencuuList();
            List<Nhanghiencuu> nhanghiencuuListNew = coquan.getNhanghiencuuList();
            List<String> illegalOrphanMessages = null;
            for (Nhanghiencuu nhanghiencuuListOldNhanghiencuu : nhanghiencuuListOld) {
                if (!nhanghiencuuListNew.contains(nhanghiencuuListOldNhanghiencuu)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nhanghiencuu " + nhanghiencuuListOldNhanghiencuu + " since its IDCoQuan field is not nullable.");
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
            coquan.setNhanghiencuuList(nhanghiencuuListNew);
            coquan = em.merge(coquan);
            for (Nhanghiencuu nhanghiencuuListNewNhanghiencuu : nhanghiencuuListNew) {
                if (!nhanghiencuuListOld.contains(nhanghiencuuListNewNhanghiencuu)) {
                    Coquan oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu = nhanghiencuuListNewNhanghiencuu.getIDCoQuan();
                    nhanghiencuuListNewNhanghiencuu.setIDCoQuan(coquan);
                    nhanghiencuuListNewNhanghiencuu = em.merge(nhanghiencuuListNewNhanghiencuu);
                    if (oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu != null && !oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu.equals(coquan)) {
                        oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu.getNhanghiencuuList().remove(nhanghiencuuListNewNhanghiencuu);
                        oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu = em.merge(oldIDCoQuanOfNhanghiencuuListNewNhanghiencuu);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = coquan.getId();
                if (findCoquan(id) == null) {
                    throw new NonexistentEntityException("The coquan with id " + id + " no longer exists.");
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
            Coquan coquan;
            try {
                coquan = em.getReference(Coquan.class, id);
                coquan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The coquan with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Nhanghiencuu> nhanghiencuuListOrphanCheck = coquan.getNhanghiencuuList();
            for (Nhanghiencuu nhanghiencuuListOrphanCheckNhanghiencuu : nhanghiencuuListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Coquan (" + coquan + ") cannot be destroyed since the Nhanghiencuu " + nhanghiencuuListOrphanCheckNhanghiencuu + " in its nhanghiencuuList field has a non-nullable IDCoQuan field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(coquan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Coquan> findCoquanEntities() {
        return findCoquanEntities(true, -1, -1);
    }

    public List<Coquan> findCoquanEntities(int maxResults, int firstResult) {
        return findCoquanEntities(false, maxResults, firstResult);
    }

    private List<Coquan> findCoquanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Coquan.class));
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

    public Coquan findCoquan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Coquan.class, id);
        } finally {
            em.close();
        }
    }

    public int getCoquanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Coquan> rt = cq.from(Coquan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
