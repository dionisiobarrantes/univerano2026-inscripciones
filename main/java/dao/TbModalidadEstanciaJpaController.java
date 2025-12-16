/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.TbModalidadEstancia;
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
import jakarta.persistence.criteria.Expression;

/**
 *
 * @author dioni
 */
@Stateless
public class TbModalidadEstanciaJpaController implements Serializable {
    public TbModalidadEstanciaJpaController(){
    this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    }
    public TbModalidadEstanciaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbModalidadEstancia tbModalidadEstancia) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbModalidadEstancia);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTbModalidadEstancia(tbModalidadEstancia.getIdModalidadEstancia()) != null) {
                throw new PreexistingEntityException("TbModalidadEstancia " + tbModalidadEstancia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbModalidadEstancia tbModalidadEstancia) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbModalidadEstancia = em.merge(tbModalidadEstancia);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbModalidadEstancia.getIdModalidadEstancia();
                if (findTbModalidadEstancia(id) == null) {
                    throw new NonexistentEntityException("The tbModalidadEstancia with id " + id + " no longer exists.");
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
            TbModalidadEstancia tbModalidadEstancia;
            try {
                tbModalidadEstancia = em.getReference(TbModalidadEstancia.class, id);
                tbModalidadEstancia.getIdModalidadEstancia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbModalidadEstancia with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbModalidadEstancia);
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

    public List<TbModalidadEstancia> findTbModalidadEstanciaEntities() {
        return findTbModalidadEstanciaEntities(true, -1, -1);
    }

    public List<TbModalidadEstancia> findTbModalidadEstanciaEntities(int maxResults, int firstResult) {
        return findTbModalidadEstanciaEntities(false, maxResults, firstResult);
    }

    private List<TbModalidadEstancia> findTbModalidadEstanciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbModalidadEstancia.class));
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

    public TbModalidadEstancia findTbModalidadEstancia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbModalidadEstancia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbModalidadEstanciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbModalidadEstancia> rt = cq.from(TbModalidadEstancia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
   public List<TbModalidadEstancia> findAllVisibles() {
       
        try (EntityManager em = getEntityManager()) {
        
jakarta.persistence.criteria.CriteriaQuery 
         cq = em.getCriteriaBuilder().createQuery(TbModalidadEstancia.class);
        Root<TbModalidadEstancia> estancia = cq.from(TbModalidadEstancia.class);
        jakarta.persistence.criteria.CriteriaBuilder cb = em.getCriteriaBuilder();        
        Short valor = 1;
        Predicate condicion1 = cb.equal(estancia.get("visible"), valor);
        cq.where(condicion1);   
        cq.orderBy(cb.asc(estancia.get("descModalidadEstancia")));
        
         return getEntityManager().createQuery(cq).getResultList();
        }
        }
        
   
  
}
