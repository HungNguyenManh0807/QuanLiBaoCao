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
import quanlibaocaokhoahoc.Model.Chucdanh;
import quanlibaocaokhoahoc.Model.Coquan;
import quanlibaocaokhoahoc.Model.NhakhoahocBaocao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import quanlibaocaokhoahoc.Model.Nhakhoahoc;
import quanlibaocaokhoahoc.exceptions.IllegalOrphanException;
import quanlibaocaokhoahoc.exceptions.NonexistentEntityException;
import quanlibaocaokhoahoc.exceptions.PreexistingEntityException;

/**
 *
 * @author Hung Nguyen
 */
public class NhakhoahocJpaController implements Serializable {

    public NhakhoahocJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nhakhoahoc nhakhoahoc) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Chucdanh IDChucDanhOrphanCheck = nhakhoahoc.getIDChucDanh();
        if (IDChucDanhOrphanCheck != null) {
            Nhakhoahoc oldNhakhoahocOfIDChucDanh = IDChucDanhOrphanCheck.getNhakhoahoc();
            if (oldNhakhoahocOfIDChucDanh != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Chucdanh " + IDChucDanhOrphanCheck + " already has an item of type Nhakhoahoc whose IDChucDanh column cannot be null. Please make another selection for the IDChucDanh field.");
            }
        }
        Coquan IDCoQuanOrphanCheck = nhakhoahoc.getIDCoQuan();
        if (IDCoQuanOrphanCheck != null) {
            Nhakhoahoc oldNhakhoahocOfIDCoQuan = IDCoQuanOrphanCheck.getNhakhoahoc();
            if (oldNhakhoahocOfIDCoQuan != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Coquan " + IDCoQuanOrphanCheck + " already has an item of type Nhakhoahoc whose IDCoQuan column cannot be null. Please make another selection for the IDCoQuan field.");
            }
        }
        NhakhoahocBaocao nhakhoahocBaocaoOrphanCheck = nhakhoahoc.getNhakhoahocBaocao();
        if (nhakhoahocBaocaoOrphanCheck != null) {
            Nhakhoahoc oldNhakhoahocOfNhakhoahocBaocao = nhakhoahocBaocaoOrphanCheck.getNhakhoahoc();
            if (oldNhakhoahocOfNhakhoahocBaocao != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The NhakhoahocBaocao " + nhakhoahocBaocaoOrphanCheck + " already has an item of type Nhakhoahoc whose nhakhoahocBaocao column cannot be null. Please make another selection for the nhakhoahocBaocao field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chucdanh IDChucDanh = nhakhoahoc.getIDChucDanh();
            if (IDChucDanh != null) {
                IDChucDanh = em.getReference(IDChucDanh.getClass(), IDChucDanh.getId());
                nhakhoahoc.setIDChucDanh(IDChucDanh);
            }
            Coquan IDCoQuan = nhakhoahoc.getIDCoQuan();
            if (IDCoQuan != null) {
                IDCoQuan = em.getReference(IDCoQuan.getClass(), IDCoQuan.getIDCoQuan());
                nhakhoahoc.setIDCoQuan(IDCoQuan);
            }
            NhakhoahocBaocao nhakhoahocBaocao = nhakhoahoc.getNhakhoahocBaocao();
            if (nhakhoahocBaocao != null) {
                nhakhoahocBaocao = em.getReference(nhakhoahocBaocao.getClass(), nhakhoahocBaocao.getNhakhoahocBaocaoPK());
                nhakhoahoc.setNhakhoahocBaocao(nhakhoahocBaocao);
            }
            em.persist(nhakhoahoc);
            if (IDChucDanh != null) {
                IDChucDanh.setNhakhoahoc(nhakhoahoc);
                IDChucDanh = em.merge(IDChucDanh);
            }
            if (IDCoQuan != null) {
                IDCoQuan.setNhakhoahoc(nhakhoahoc);
                IDCoQuan = em.merge(IDCoQuan);
            }
            if (nhakhoahocBaocao != null) {
                nhakhoahocBaocao.setNhakhoahoc(nhakhoahoc);
                nhakhoahocBaocao = em.merge(nhakhoahocBaocao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNhakhoahoc(nhakhoahoc.getId()) != null) {
                throw new PreexistingEntityException("Nhakhoahoc " + nhakhoahoc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nhakhoahoc nhakhoahoc) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nhakhoahoc persistentNhakhoahoc = em.find(Nhakhoahoc.class, nhakhoahoc.getId());
            Chucdanh IDChucDanhOld = persistentNhakhoahoc.getIDChucDanh();
            Chucdanh IDChucDanhNew = nhakhoahoc.getIDChucDanh();
            Coquan IDCoQuanOld = persistentNhakhoahoc.getIDCoQuan();
            Coquan IDCoQuanNew = nhakhoahoc.getIDCoQuan();
            NhakhoahocBaocao nhakhoahocBaocaoOld = persistentNhakhoahoc.getNhakhoahocBaocao();
            NhakhoahocBaocao nhakhoahocBaocaoNew = nhakhoahoc.getNhakhoahocBaocao();
            List<String> illegalOrphanMessages = null;
            if (IDChucDanhNew != null && !IDChucDanhNew.equals(IDChucDanhOld)) {
                Nhakhoahoc oldNhakhoahocOfIDChucDanh = IDChucDanhNew.getNhakhoahoc();
                if (oldNhakhoahocOfIDChucDanh != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Chucdanh " + IDChucDanhNew + " already has an item of type Nhakhoahoc whose IDChucDanh column cannot be null. Please make another selection for the IDChucDanh field.");
                }
            }
            if (IDCoQuanNew != null && !IDCoQuanNew.equals(IDCoQuanOld)) {
                Nhakhoahoc oldNhakhoahocOfIDCoQuan = IDCoQuanNew.getNhakhoahoc();
                if (oldNhakhoahocOfIDCoQuan != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Coquan " + IDCoQuanNew + " already has an item of type Nhakhoahoc whose IDCoQuan column cannot be null. Please make another selection for the IDCoQuan field.");
                }
            }
            if (nhakhoahocBaocaoNew != null && !nhakhoahocBaocaoNew.equals(nhakhoahocBaocaoOld)) {
                Nhakhoahoc oldNhakhoahocOfNhakhoahocBaocao = nhakhoahocBaocaoNew.getNhakhoahoc();
                if (oldNhakhoahocOfNhakhoahocBaocao != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The NhakhoahocBaocao " + nhakhoahocBaocaoNew + " already has an item of type Nhakhoahoc whose nhakhoahocBaocao column cannot be null. Please make another selection for the nhakhoahocBaocao field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (IDChucDanhNew != null) {
                IDChucDanhNew = em.getReference(IDChucDanhNew.getClass(), IDChucDanhNew.getId());
                nhakhoahoc.setIDChucDanh(IDChucDanhNew);
            }
            if (IDCoQuanNew != null) {
                IDCoQuanNew = em.getReference(IDCoQuanNew.getClass(), IDCoQuanNew.getIDCoQuan());
                nhakhoahoc.setIDCoQuan(IDCoQuanNew);
            }
            if (nhakhoahocBaocaoNew != null) {
                nhakhoahocBaocaoNew = em.getReference(nhakhoahocBaocaoNew.getClass(), nhakhoahocBaocaoNew.getNhakhoahocBaocaoPK());
                nhakhoahoc.setNhakhoahocBaocao(nhakhoahocBaocaoNew);
            }
            nhakhoahoc = em.merge(nhakhoahoc);
            if (IDChucDanhOld != null && !IDChucDanhOld.equals(IDChucDanhNew)) {
                IDChucDanhOld.setNhakhoahoc(null);
                IDChucDanhOld = em.merge(IDChucDanhOld);
            }
            if (IDChucDanhNew != null && !IDChucDanhNew.equals(IDChucDanhOld)) {
                IDChucDanhNew.setNhakhoahoc(nhakhoahoc);
                IDChucDanhNew = em.merge(IDChucDanhNew);
            }
            if (IDCoQuanOld != null && !IDCoQuanOld.equals(IDCoQuanNew)) {
                IDCoQuanOld.setNhakhoahoc(null);
                IDCoQuanOld = em.merge(IDCoQuanOld);
            }
            if (IDCoQuanNew != null && !IDCoQuanNew.equals(IDCoQuanOld)) {
                IDCoQuanNew.setNhakhoahoc(nhakhoahoc);
                IDCoQuanNew = em.merge(IDCoQuanNew);
            }
            if (nhakhoahocBaocaoOld != null && !nhakhoahocBaocaoOld.equals(nhakhoahocBaocaoNew)) {
                nhakhoahocBaocaoOld.setNhakhoahoc(null);
                nhakhoahocBaocaoOld = em.merge(nhakhoahocBaocaoOld);
            }
            if (nhakhoahocBaocaoNew != null && !nhakhoahocBaocaoNew.equals(nhakhoahocBaocaoOld)) {
                nhakhoahocBaocaoNew.setNhakhoahoc(nhakhoahoc);
                nhakhoahocBaocaoNew = em.merge(nhakhoahocBaocaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nhakhoahoc.getId();
                if (findNhakhoahoc(id) == null) {
                    throw new NonexistentEntityException("The nhakhoahoc with id " + id + " no longer exists.");
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
            Nhakhoahoc nhakhoahoc;
            try {
                nhakhoahoc = em.getReference(Nhakhoahoc.class, id);
                nhakhoahoc.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nhakhoahoc with id " + id + " no longer exists.", enfe);
            }
            Chucdanh IDChucDanh = nhakhoahoc.getIDChucDanh();
            if (IDChucDanh != null) {
                IDChucDanh.setNhakhoahoc(null);
                IDChucDanh = em.merge(IDChucDanh);
            }
            Coquan IDCoQuan = nhakhoahoc.getIDCoQuan();
            if (IDCoQuan != null) {
                IDCoQuan.setNhakhoahoc(null);
                IDCoQuan = em.merge(IDCoQuan);
            }
            NhakhoahocBaocao nhakhoahocBaocao = nhakhoahoc.getNhakhoahocBaocao();
            if (nhakhoahocBaocao != null) {
                nhakhoahocBaocao.setNhakhoahoc(null);
                nhakhoahocBaocao = em.merge(nhakhoahocBaocao);
            }
            em.remove(nhakhoahoc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nhakhoahoc> findNhakhoahocEntities() {
        return findNhakhoahocEntities(true, -1, -1);
    }

    public List<Nhakhoahoc> findNhakhoahocEntities(int maxResults, int firstResult) {
        return findNhakhoahocEntities(false, maxResults, firstResult);
    }

    private List<Nhakhoahoc> findNhakhoahocEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nhakhoahoc.class));
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

    public Nhakhoahoc findNhakhoahoc(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nhakhoahoc.class, id);
        } finally {
            em.close();
        }
    }

    public int getNhakhoahocCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nhakhoahoc> rt = cq.from(Nhakhoahoc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
