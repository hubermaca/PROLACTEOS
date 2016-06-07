/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.modelo;

import co.com.entidades.PlEmpleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author porta
 */
public class EmpleadoDaoJpa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PROLACTEOSPU");
    EntityManager em = emf.createEntityManager();

    public void crearEmpleado(PlEmpleado pe) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.persist(pe);
        transaction.commit();
    }

    public List listAll() {

        String jpql = "Select a from " + PlEmpleado.class.getName() + " a";
        Query result = em.createQuery(jpql, PlEmpleado.class);
        List empleadosList = result.getResultList();

        return empleadosList;
    }

    public void actualizarEmpleado(Integer codigo, String nombres) {
        System.out.println("codigooooo" + codigo);
        PlEmpleado emp = findByIdentificacion(codigo);
        em.getTransaction().begin();
                System.out.println("1__" + nombres);
//        System.out.println("2____" + emp.getNombres());

        emp.setNombres(nombres);

        
        em.merge(emp);
        em.getTransaction().commit();
    }

   public  PlEmpleado findByIdentificacion(Integer codigo) {

        em.getTransaction().begin();
        PlEmpleado emp = em.find(PlEmpleado.class, codigo);
        em.getTransaction().commit();
        return emp;
    }

}
