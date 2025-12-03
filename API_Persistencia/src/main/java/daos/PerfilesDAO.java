/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dominio.Perfil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author gael_
 */
public class PerfilesDAO {
    
    public void agregarPerfil(Perfil perfil){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(perfil);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    
    public List<Perfil> obtenerPerfiles(){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Perfil p", Perfil.class)
                     .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Perfil> obtenerPerfiles(int edad, String pais, String genero) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            String jpql = "SELECT p FROM Perfil p WHERE p.edad = :edad AND p.pais = :pais AND p.genero = :genero";

            TypedQuery<Perfil> query = entityManager.createQuery(jpql, Perfil.class);

            query.setParameter("edad", edad);
            query.setParameter("pais", pais);
            query.setParameter("genero", genero);

            return query.getResultList();
            
        } finally {

            entityManager.close();
        }
    }
    
}
    
    

