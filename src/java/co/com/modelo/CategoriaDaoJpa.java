package co.com.modelo;

import co.com.entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jj
 */
public class CategoriaDaoJpa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROLACTEOSPU");
    EntityManager em = emf.createEntityManager();

    public void crearCategoria(Categoria categoria) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        em.persist(categoria);
        transaction.commit();
    }

    public List listAll() {

        String jpql = "Select a from " + Categoria.class.getName() + " a";
        Query result = em.createQuery(jpql, Categoria.class);
        List categoriaList = result.getResultList();

        return categoriaList;
    }

}
