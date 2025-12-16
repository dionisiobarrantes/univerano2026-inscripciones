/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.TbModalidadEstancia;
import entidades.TbTarifa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.UserTransaction;
import java.util.List;
import jakarta.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author dioni
 */
@Stateless
public class TbTarifaJpaController implements Serializable {

    public TbTarifaJpaController() {
        this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    }
    public TbTarifaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbTarifa tbTarifa) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbTarifa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTbTarifa(tbTarifa.getIdTarifa()) != null) {
                throw new PreexistingEntityException("TbTarifa " + tbTarifa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbTarifa tbTarifa) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbTarifa = em.merge(tbTarifa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbTarifa.getIdTarifa();
                if (findTbTarifa(id) == null) {
                    throw new NonexistentEntityException("The tbTarifa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            TbTarifa tbTarifa;
            try {
                tbTarifa = em.getReference(TbTarifa.class, id);
                tbTarifa.getIdTarifa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbTarifa with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbTarifa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbTarifa> findTbTarifaEntities() {
        return findTbTarifaEntities(true, -1, -1);
    }

    public List<TbTarifa> findTbTarifaEntities(int maxResults, int firstResult) {
        return findTbTarifaEntities(false, maxResults, firstResult);
    }

    private List<TbTarifa> findTbTarifaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbTarifa.class));
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

    public TbTarifa findTbTarifa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbTarifa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbTarifaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbTarifa> rt = cq.from(TbTarifa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public List<TbTarifa> findAllVisibles() {
       
        try (EntityManager em = getEntityManager()) {
        
jakarta.persistence.criteria.CriteriaQuery 
         cq = em.getCriteriaBuilder().createQuery(TbTarifa.class);
        Root<TbTarifa> tarifa = cq.from(TbTarifa.class);
        jakarta.persistence.criteria.CriteriaBuilder cb = em.getCriteriaBuilder();        
        Short valor = 1;
        Predicate condicion1 = cb.equal(tarifa.get("visible"), valor);
        cq.where(condicion1);   
        cq.orderBy(cb.asc(tarifa.get("descTarifa")));
        
         return getEntityManager().createQuery(cq).getResultList();
        }
        }
    
    
}
