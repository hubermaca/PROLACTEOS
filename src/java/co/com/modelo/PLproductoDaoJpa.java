/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Import de entidad a persistir
import co.com.entidades.Plproducto;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jj
 */
public class PLproductoDaoJpa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROLACTEOSPU");
    EntityManager em = emf.createEntityManager();

    public void crearProducto(Plproducto p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.persist(p);
        transaction.commit();
    }

    public List listAll() {

        String jpql = "Select a from " + Plproducto.class.getName() + " a";
        Query result = em.createQuery(jpql, Plproducto.class);
        List productosList = result.getResultList();

        return productosList;
    }

}
