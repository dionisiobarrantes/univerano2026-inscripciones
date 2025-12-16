/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.TbOcupacion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 *
 * @author dioni
 */
@Stateless
public class TbOcupacionJpaController implements Serializable {
     public TbOcupacionJpaController(){
     this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
     }
    public TbOcupacionJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbOcupacion tbOcupacion) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbOcupacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTbOcupacion(tbOcupacion.getIdOcupacion()) != null) {
                throw new PreexistingEntityException("TbOcupacion " + tbOcupacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbOcupacion tbOcupacion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbOcupacion = em.merge(tbOcupacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbOcupacion.getIdOcupacion();
                if (findTbOcupacion(id) == null) {
                    throw new NonexistentEntityException("The tbOcupacion with id " + id + " no longer exists.");
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
            TbOcupacion tbOcupacion;
            try {
                tbOcupacion = em.getReference(TbOcupacion.class, id);
                tbOcupacion.getIdOcupacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbOcupacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbOcupacion);
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

    public List<TbOcupacion> findTbOcupacionEntities() {
        return findTbOcupacionEntities(true, -1, -1);
    }

    public List<TbOcupacion> findTbOcupacionEntities(int maxResults, int firstResult) {
        return findTbOcupacionEntities(false, maxResults, firstResult);
    }

    private List<TbOcupacion> findTbOcupacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbOcupacion.class));
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

    public TbOcupacion findTbOcupacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbOcupacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbOcupacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbOcupacion> rt = cq.from(TbOcupacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
