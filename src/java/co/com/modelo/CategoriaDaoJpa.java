
package co.com.modelo;

import co.com.entidades.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jj
 */
public class CategoriaDaoJpa {

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("PROLACTEOSPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public void crearCategoria(Categoria categoria) {
        tx.begin();
        em.persist(categoria);
        tx.commit();
    }

}
