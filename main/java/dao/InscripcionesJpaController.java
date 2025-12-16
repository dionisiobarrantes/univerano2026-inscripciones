/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.Inscripciones;
import entidades.TbTarifa;

import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;


import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author dioni
 */
@Stateless
public class InscripcionesJpaController implements Serializable {
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public InscripcionesJpaController() throws NamingException{
    this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    this.utx = InitialContext.doLookup("UserTransaction");
    }
    public InscripcionesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inscripciones inscripciones) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
//          utx.begin();
            em = getEntityManager();
            em.persist(inscripciones);
//          utx.commit();
        } catch (IllegalStateException | SecurityException ex)
        {
            try {
                utx.rollback();
            } catch (SystemException | IllegalStateException | SecurityException re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inscripciones inscripciones) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            inscripciones = em.merge(inscripciones);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = inscripciones.getIdInscripcion();
                if (findInscripciones(id) == null) {
                    throw new NonexistentEntityException("The inscripciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Inscripciones inscripciones;
            try {
                inscripciones = em.getReference(Inscripciones.class, id);
                inscripciones.getIdInscripcion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(inscripciones);
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

    public List<Inscripciones> findInscripcionesEntities() {
        return findInscripcionesEntities(true, -1, -1);
    }

    public List<Inscripciones> findInscripcionesEntities(int maxResults, int firstResult) {
        return findInscripcionesEntities(false, maxResults, firstResult);
    }

    private List<Inscripciones> findInscripcionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inscripciones.class));
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

    public Inscripciones findInscripciones(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inscripciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getInscripcionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inscripciones> rt = cq.from(Inscripciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
           
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
      public Boolean doInscripcionesDuplicadosCount(String dniNie, String duracionEstancia, Integer modalidadEstancia) {
          List<Inscripciones> listaDuplicados = new ArrayList<Inscripciones>();
          ListIterator<Inscripciones> it = listaDuplicados.listIterator();
          EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            List<Predicate> predicates = new ArrayList<Predicate>();
           
            jakarta.persistence.criteria.CriteriaQuery cbp = getEntityManager().getCriteriaBuilder().createQuery();
            Root<Inscripciones> rt = cbp.from(Inscripciones.class);
            CriteriaBuilder cb = em.getCriteriaBuilder();
            predicates.add(cb.equal(rt.get("dniNie"), dniNie));
            predicates.add(cb.equal(rt.get("duracionEstancia"), duracionEstancia));
            predicates.add(cb.equal(rt.get("modalidadEstancia"), modalidadEstancia));
            cbp.where((predicates.toArray(new Predicate[]{})));
           
          
            listaDuplicados = getEntityManager().createQuery(cbp).getResultList();
                   
             return (Boolean) listaDuplicados.isEmpty();
        } finally {
            em.close();
        }
    } 
}
