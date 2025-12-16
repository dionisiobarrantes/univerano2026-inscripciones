/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.TbPrecios;
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
import java.util.ArrayList;

/**
 *
 * @author dioni
 */
@Stateless
public class TbPreciosJpaController implements Serializable {

    public TbPreciosJpaController(){
     this.emf = (jakarta.persistence.EntityManagerFactory) Persistence.createEntityManagerFactory("my_persistence_unit");
    }
    public TbPreciosJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbPrecios tbPrecios) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tbPrecios);
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

    public void edit(TbPrecios tbPrecios) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tbPrecios = em.merge(tbPrecios);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = tbPrecios.getIdPrecio();
                if (findTbPrecios(id) == null) {
                    throw new NonexistentEntityException("The tbPrecios with id " + id + " no longer exists.");
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
            TbPrecios tbPrecios;
            try {
                tbPrecios = em.getReference(TbPrecios.class, id);
                tbPrecios.getIdPrecio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbPrecios with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbPrecios);
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

    public List<TbPrecios> findTbPreciosEntities() {
        return findTbPreciosEntities(true, -1, -1);
    }

    public List<TbPrecios> findTbPreciosEntities(int maxResults, int firstResult) {
        return findTbPreciosEntities(false, maxResults, firstResult);
    }

    public List<TbPrecios> findPreciosCalculadora(Integer modalidadEstancia, Integer tarifa, Integer antes_despues) {
        try (EntityManager em = getEntityManager()) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            jakarta.persistence.criteria.CriteriaQuery cbp = getEntityManager().getCriteriaBuilder().createQuery();
            Root<TbPrecios> precio = cbp.from(TbPrecios.class);
            CriteriaBuilder cb = em.getCriteriaBuilder();

            predicates.add(cb.equal(precio.get("idModalidad"), modalidadEstancia));
            predicates.add(cb.equal(precio.get("idTarifa"), tarifa));
            predicates.add(cb.equal(precio.get("idAntesDespues"), antes_despues));
            cbp.where((predicates.toArray(new Predicate[]{})));
            List<TbPrecios> listaSalida = getEntityManager().createQuery(cbp).getResultList();
            return listaSalida;

        }
    }
    private List<TbPrecios> findTbPreciosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbPrecios.class));
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

    public TbPrecios findTbPrecios(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbPrecios.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbPreciosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbPrecios> rt = cq.from(TbPrecios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
   public List<TbPrecios> findPrecios(Integer modalidadEstancia, Integer tarifa) {
         
try (EntityManager em = getEntityManager()) {       
         jakarta.persistence.criteria.CriteriaQuery 
         cq = em.getCriteriaBuilder().createQuery(TbPrecios.class);   
        
        Root<TbPrecios> precio = cq.from(TbPrecios.class);
        
        jakarta.persistence.criteria.CriteriaBuilder cb = em.getCriteriaBuilder();   
        
        Predicate condicion1 = cb.equal(precio.get("idModalidad"), modalidadEstancia);
        Predicate condicion2 = cb.equal(precio.get("idTarifa"), tarifa);
         
        cq.where(condicion1,condicion2);
        
        
    List listaSalida = getEntityManager().createQuery(cq).getResultList();   
 //   Object salida = listaSalida.get(0);
        return listaSalida;  
    } 
   }
   

}
