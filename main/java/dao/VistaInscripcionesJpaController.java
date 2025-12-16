/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.VistaInscripciones;
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
public class VistaInscripcionesJpaController implements Serializable {
    
    public VistaInscripcionesJpaController() {
        this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public VistaInscripcionesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VistaInscripciones vistaInscripciones) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(vistaInscripciones);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findVistaInscripciones(vistaInscripciones.getIdInscripcion()) != null) {
                throw new PreexistingEntityException("VistaInscripciones " + vistaInscripciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VistaInscripciones vistaInscripciones) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            vistaInscripciones = em.merge(vistaInscripciones);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                short id = vistaInscripciones.getIdInscripcion();
                if (findVistaInscripciones(id) == null) {
                    throw new NonexistentEntityException("The vistaInscripciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(short id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            VistaInscripciones vistaInscripciones;
            try {
                vistaInscripciones = em.getReference(VistaInscripciones.class, id);
                vistaInscripciones.getIdInscripcion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vistaInscripciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(vistaInscripciones);
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

    public List<VistaInscripciones> findVistaInscripcionesEntities() {
        return findVistaInscripcionesEntities(true, -1, -1);
    }

    public List<VistaInscripciones> findVistaInscripcionesEntities(int maxResults, int firstResult) {
        return findVistaInscripcionesEntities(false, maxResults, firstResult);
    }

    private List<VistaInscripciones> findVistaInscripcionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VistaInscripciones.class));
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

    public VistaInscripciones findVistaInscripciones(short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VistaInscripciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getVistaInscripcionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VistaInscripciones> rt = cq.from(VistaInscripciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
