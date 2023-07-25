
package com.desarrolloapisspringboot.Veterinaria.service;


import com.desarrolloapisspringboot.Veterinaria.dto.DueñoMascotaDTO;
import com.desarrolloapisspringboot.Veterinaria.model.Dueño;
import com.desarrolloapisspringboot.Veterinaria.model.Mascota;
import com.desarrolloapisspringboot.Veterinaria.repository.IDueñoRepository;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DueñoService implements IDueñoService{
    
    @Autowired
    private IDueñoRepository dueñoRepo;
    

    @Override
    public void saveDueño(Dueño dueño) {
        this.dueñoRepo.save(dueño);
    }

    @Override
    public List<Dueño> getDueño() {
        return dueñoRepo.findAll();
    }

    @Override
    public void editDueño(Dueño dueño) {
        this.saveDueño(dueño);
    }

    @Override
    public void deleteDueño(Long id_dueño) {
        this.dueñoRepo.deleteById(id_dueño);
    }

   

    @Override
    public Dueño findDueño(Long id_dueño) {
        return this.dueñoRepo.findById(id_dueño).orElse(null);
    }

   @Override
    public List<DueñoMascotaDTO> listarDueñoMascota() {
        
        List<DueñoMascotaDTO> listaDTO=new ArrayList<>();
        List<Dueño> listaDueño=this.getDueño();
        DueñoMascotaDTO dmDTO=new DueñoMascotaDTO();
        
        for(Dueño dueño:listaDueño){
            System.out.println(dueño.getApellido_dueño());
            dmDTO.setNombre_dueño(dueño.getNombre_dueño());
            dmDTO.setApellido_dueño(dueño.getApellido_dueño());
            dmDTO.setEspecie(dueño.getMascot().getEspecie());
            dmDTO.setNombre_mascota(dueño.getMascot().getNombre_mascota());
            dmDTO.setRaza(dueño.getMascot().getRaza());
            
            listaDTO.add(dmDTO);
            System.out.println(dmDTO);
            dmDTO=new DueñoMascotaDTO(); //reseteo
            System.out.println("Luego del reseteo: " + dmDTO);
        }
        
    return listaDTO;
    }
}
