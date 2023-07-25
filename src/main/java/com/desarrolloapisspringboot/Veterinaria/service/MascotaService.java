
package com.desarrolloapisspringboot.Veterinaria.service;

import com.desarrolloapisspringboot.Veterinaria.model.Mascota;
import com.desarrolloapisspringboot.Veterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService  implements IMascotaService{
 
    @Autowired
    private IMascotaRepository mascotRepo;
    
    
    
    @Override
    public void saveMascota(Mascota mascot) {
        this.mascotRepo.save(mascot);
    }

    @Override
    public List<Mascota> getMascotas() {
        return this.mascotRepo.findAll();
    }

    @Override
    public void editMascota(Mascota mascot) {
        this.saveMascota(mascot);
    }

    @Override
    public void deleteMascota(Long id_mascot) {
        this.mascotRepo.deleteById(id_mascot);
    }

    @Override
    public List<Mascota> getMascotEspRaza() {
        String raza="caniche";
        String especie="perro";
        
        List<Mascota> listaMascotas=this.getMascotas();
        List<Mascota> listaPorEspRaza=new ArrayList<>();
        
        for(Mascota mascot:listaMascotas){
            String palabraRaza=mascot.getRaza();
            String palabra=mascot.getEspecie();
            if(palabraRaza.equalsIgnoreCase(raza) && palabra.equalsIgnoreCase(especie))
                listaPorEspRaza.add(mascot);
                }
        return listaPorEspRaza;
        
    }

    @Override
    public Mascota findMascota(Long id_mascot) {
        return this.mascotRepo.findById(id_mascot).orElse(null);
    }
    
}
