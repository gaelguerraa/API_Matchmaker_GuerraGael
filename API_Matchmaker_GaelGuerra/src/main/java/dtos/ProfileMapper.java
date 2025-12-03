/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import dominio.Perfil;
import java.util.Calendar;

/**
 *
 * @author gael_
 */
public class ProfileMapper {
    public static Perfil mapToEntity(ProfileDTO dto) {
        return new Perfil(
            dto.getNombre(), dto.getApellidoPaterno(), dto.getApellidoMaterno(),
            dto.getFechaNacimiento(), dto.getFoto(), dto.getEmail(),
            dto.getGenero(), dto.getPais(), dto.getTelefono(),
            dto.getCelular(), dto.getDireccion(), dto.getEdad()
        );
    }
    
    public static ProfileDTO mapToDTO(Perfil perfil) {
        ProfileDTO dto = new ProfileDTO();
        dto.setNombre(perfil.getNombre());
        dto.setApellidoPaterno(perfil.getApellidoPaterno());
        dto.setApellidoMaterno(perfil.getApellidoMaterno());
        dto.setFechaNacimiento(perfil.getFechaNacimiento());
        dto.setFoto(perfil.getFoto());
        dto.setEmail(perfil.getEmail());
        dto.setGenero(perfil.getGenero());
        dto.setPais(perfil.getPais());
        dto.setTelefono(perfil.getTelefono());
        dto.setCelular(perfil.getCelular());
        dto.setDireccion(perfil.getDireccion());
        dto.setEdad(perfil.getEdad());
        return dto;
    }
}
