/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.TbCcaa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.UserTransaction;
import java.util.List;
import exceptions.NonexistentEntityException;
import exceptions.PreexistingEntityException;
import exceptions.RollbackFailureException;

/**
 *
 * @author dioni
 */
@Stateless
public class TbCcaaJpaController implements Serializable {
 public TbCcaaJpaController(){
     this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
 };
    
    
    public TbCcaaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbCcaa tbCcaa) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbCcaa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTbCcaa(tbCcaa.getIdCcaa()) != null) {
                throw new PreexistingEntityException("TbCcaa " + tbCcaa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbCcaa tbCcaa) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbCcaa = em.merge(tbCcaa);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbCcaa.getIdCcaa();
                if (findTbCcaa(id) == null) {
                    throw new NonexistentEntityException("The tbCcaa with id " + id + " no longer exists.");
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
            TbCcaa tbCcaa;
            try {
                tbCcaa = em.getReference(TbCcaa.class, id);
                tbCcaa.getIdCcaa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbCcaa with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbCcaa);
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

    public List<TbCcaa> findTbCcaaEntities() {
        return findTbCcaaEntities(true, -1, -1);
    }

    public List<TbCcaa> findTbCcaaEntities(int maxResults, int firstResult) {
        return findTbCcaaEntities(false, maxResults, firstResult);
    }

    private List<TbCcaa> findTbCcaaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbCcaa.class));
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

    public TbCcaa findTbCcaa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbCcaa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbCcaaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbCcaa> rt = cq.from(TbCcaa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<TbCcaa> findCCAATodas() {
        List<TbCcaa> listaCCAA;
        try (EntityManager em = getEntityManager()) 
        {
            CriteriaBuilder cb=(CriteriaBuilder) em.getCriteriaBuilder();  
            CriteriaQuery<TbCcaa> cq = cb.createQuery(TbCcaa.class);
            Root<TbCcaa> usr;  
            usr = cq.from(TbCcaa.class);
            jakarta.persistence.Query q;
            q = (jakarta.persistence.Query) em.createQuery(cq);
     
 //           String queryString ="SELECT t FROM TbCcaa t";
 //           TypedQuery<TbCcaa> q = (TypedQuery<TbCcaa>) getEntityManager().createQuery(queryString,TbCcaa.class);
            listaCCAA = q.getResultList();
                    

            
            return ( listaCCAA);
    }
    }  

}
