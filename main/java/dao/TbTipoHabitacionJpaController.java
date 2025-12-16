/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.TbTipoHabitacion;
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
public class TbTipoHabitacionJpaController implements Serializable {

    public TbTipoHabitacionJpaController(){
     this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    }
    
    public TbTipoHabitacionJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbTipoHabitacion tbTipoHabitacion) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbTipoHabitacion);
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

    public void edit(TbTipoHabitacion tbTipoHabitacion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbTipoHabitacion = em.merge(tbTipoHabitacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbTipoHabitacion.getIdTipoHabitacion();
                if (findTbTipoHabitacion(id) == null) {
                    throw new NonexistentEntityException("The tbTipoHabitacion with id " + id + " no longer exists.");
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
            TbTipoHabitacion tbTipoHabitacion;
            try {
                tbTipoHabitacion = em.getReference(TbTipoHabitacion.class, id);
                tbTipoHabitacion.getIdTipoHabitacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbTipoHabitacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbTipoHabitacion);
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

    public List<TbTipoHabitacion> findTbTipoHabitacionEntities() {
        return findTbTipoHabitacionEntities(true, -1, -1);
    }

    public List<TbTipoHabitacion> findTbTipoHabitacionEntities(int maxResults, int firstResult) {
        return findTbTipoHabitacionEntities(false, maxResults, firstResult);
    }

    private List<TbTipoHabitacion> findTbTipoHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbTipoHabitacion.class));
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

    public TbTipoHabitacion findTbTipoHabitacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbTipoHabitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbTipoHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbTipoHabitacion> rt = cq.from(TbTipoHabitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
