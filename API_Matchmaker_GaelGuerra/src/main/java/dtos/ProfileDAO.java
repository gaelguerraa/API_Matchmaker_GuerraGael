/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import daos.ManejadorConexiones;
import dominio.Perfil;
import jakarta.enterprise.context.Dependent;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author gael_
 */
@Dependent
public class ProfileDAO {
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
}
