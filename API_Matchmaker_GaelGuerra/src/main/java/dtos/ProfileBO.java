/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import dominio.Perfil;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gael_
 */

@RequestScoped
public class ProfileBO {
    
    @Inject
    private ProfileDAO perfilDAO; 
    private final Random random = new Random();
    
    public  ProfileDTO encontrarMatch(String genero, String pais, int edad) {

        List<Perfil> todosLosPerfiles = perfilDAO.obtenerPerfiles(); 
        
        List<Perfil> candidatos = new ArrayList<>();
        int maxScore = 0;

        for (Perfil perfil : todosLosPerfiles) {
            int score = 0;

            if (perfil.getGenero() != null && perfil.getGenero().equalsIgnoreCase(genero)) {
                score++;
            }

            if (perfil.getPais() != null && perfil.getPais().equalsIgnoreCase(pais)) {
                score++;
            }

            if (perfil.getEdad() == edad) { 
                score++;
            }

            if (score >= 2) {
                candidatos.add(perfil);
                maxScore = Math.max(maxScore, score);
            }
        }
        
        List<Perfil> bestMatches = new ArrayList<>();
        for (Perfil perfil : candidatos) {
            int currentScore = 0;
            if (perfil.getGenero() != null && perfil.getGenero().equalsIgnoreCase(genero)) currentScore++;
            if (perfil.getPais() != null && perfil.getPais().equalsIgnoreCase(pais)) currentScore++;
            if (perfil.getEdad() == edad) currentScore++;

            if (currentScore == maxScore) {
                bestMatches.add(perfil);
            }
        }
        
        if (!bestMatches.isEmpty()) {
            Perfil selected = bestMatches.get(random.nextInt(bestMatches.size()));

            return ProfileMapper.mapToDTO(selected); 
        }

        return null; 
    }


}
