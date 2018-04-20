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
import quanlibaocaokhoahoc.Model.NhanghiencuuBaocao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Controller.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.Controller.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.Controller.exceptions.PreexistingEntityException;
import quanlibaocaokhoahoc.Model.Vaitro;

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
        if (vaitro.getNhanghiencuuBaocaoList() == null) {
            vaitro.setNhanghiencuuBaocaoList(new ArrayList<NhanghiencuuBaocao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<NhanghiencuuBaocao> attachedNhanghiencuuBaocaoList = new ArrayList<NhanghiencuuBaocao>();
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListNhanghiencuuBaocaoToAttach : vaitro.getNhanghiencuuBaocaoList()) {
                nhanghiencuuBaocaoListNhanghiencuuBaocaoToAttach = em.getReference(nhanghiencuuBaocaoListNhanghiencuuBaocaoToAttach.getClass(), nhanghiencuuBaocaoListNhanghiencuuBaocaoToAttach.getNhanghiencuuBaocaoPK());
                attachedNhanghiencuuBaocaoList.add(nhanghiencuuBaocaoListNhanghiencuuBaocaoToAttach);
            }
            vaitro.setNhanghiencuuBaocaoList(attachedNhanghiencuuBaocaoList);
            em.persist(vaitro);
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListNhanghiencuuBaocao : vaitro.getNhanghiencuuBaocaoList()) {
                Vaitro oldIDVaiTroOfNhanghiencuuBaocaoListNhanghiencuuBaocao = nhanghiencuuBaocaoListNhanghiencuuBaocao.getIDVaiTro();
                nhanghiencuuBaocaoListNhanghiencuuBaocao.setIDVaiTro(vaitro);
                nhanghiencuuBaocaoListNhanghiencuuBaocao = em.merge(nhanghiencuuBaocaoListNhanghiencuuBaocao);
                if (oldIDVaiTroOfNhanghiencuuBaocaoListNhanghiencuuBaocao != null) {
                    oldIDVaiTroOfNhanghiencuuBaocaoListNhanghiencuuBaocao.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocaoListNhanghiencuuBaocao);
                    oldIDVaiTroOfNhanghiencuuBaocaoListNhanghiencuuBaocao = em.merge(oldIDVaiTroOfNhanghiencuuBaocaoListNhanghiencuuBaocao);
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
            List<NhanghiencuuBaocao> nhanghiencuuBaocaoListOld = persistentVaitro.getNhanghiencuuBaocaoList();
            List<NhanghiencuuBaocao> nhanghiencuuBaocaoListNew = vaitro.getNhanghiencuuBaocaoList();
            List<String> illegalOrphanMessages = null;
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListOldNhanghiencuuBaocao : nhanghiencuuBaocaoListOld) {
                if (!nhanghiencuuBaocaoListNew.contains(nhanghiencuuBaocaoListOldNhanghiencuuBaocao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain NhanghiencuuBaocao " + nhanghiencuuBaocaoListOldNhanghiencuuBaocao + " since its IDVaiTro field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<NhanghiencuuBaocao> attachedNhanghiencuuBaocaoListNew = new ArrayList<NhanghiencuuBaocao>();
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListNewNhanghiencuuBaocaoToAttach : nhanghiencuuBaocaoListNew) {
                nhanghiencuuBaocaoListNewNhanghiencuuBaocaoToAttach = em.getReference(nhanghiencuuBaocaoListNewNhanghiencuuBaocaoToAttach.getClass(), nhanghiencuuBaocaoListNewNhanghiencuuBaocaoToAttach.getNhanghiencuuBaocaoPK());
                attachedNhanghiencuuBaocaoListNew.add(nhanghiencuuBaocaoListNewNhanghiencuuBaocaoToAttach);
            }
            nhanghiencuuBaocaoListNew = attachedNhanghiencuuBaocaoListNew;
            vaitro.setNhanghiencuuBaocaoList(nhanghiencuuBaocaoListNew);
            vaitro = em.merge(vaitro);
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListNewNhanghiencuuBaocao : nhanghiencuuBaocaoListNew) {
                if (!nhanghiencuuBaocaoListOld.contains(nhanghiencuuBaocaoListNewNhanghiencuuBaocao)) {
                    Vaitro oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao = nhanghiencuuBaocaoListNewNhanghiencuuBaocao.getIDVaiTro();
                    nhanghiencuuBaocaoListNewNhanghiencuuBaocao.setIDVaiTro(vaitro);
                    nhanghiencuuBaocaoListNewNhanghiencuuBaocao = em.merge(nhanghiencuuBaocaoListNewNhanghiencuuBaocao);
                    if (oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao != null && !oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao.equals(vaitro)) {
                        oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao.getNhanghiencuuBaocaoList().remove(nhanghiencuuBaocaoListNewNhanghiencuuBaocao);
                        oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao = em.merge(oldIDVaiTroOfNhanghiencuuBaocaoListNewNhanghiencuuBaocao);
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
            List<NhanghiencuuBaocao> nhanghiencuuBaocaoListOrphanCheck = vaitro.getNhanghiencuuBaocaoList();
            for (NhanghiencuuBaocao nhanghiencuuBaocaoListOrphanCheckNhanghiencuuBaocao : nhanghiencuuBaocaoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vaitro (" + vaitro + ") cannot be destroyed since the NhanghiencuuBaocao " + nhanghiencuuBaocaoListOrphanCheckNhanghiencuuBaocao + " in its nhanghiencuuBaocaoList field has a non-nullable IDVaiTro field.");
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
