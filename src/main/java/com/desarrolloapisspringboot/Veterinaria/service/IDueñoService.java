
package com.desarrolloapisspringboot.Veterinaria.service;

import com.desarrolloapisspringboot.Veterinaria.dto.DueñoMascotaDTO;
import com.desarrolloapisspringboot.Veterinaria.model.Dueño;
import java.util.List;


public interface IDueñoService {
     
    
    public void saveDueño(Dueño dueño);
    public List<Dueño> getDueño();
    public void editDueño(Dueño dueño);
    public void deleteDueño(Long id_dueño);
    public List<DueñoMascotaDTO> listarDueñoMascota();
    public Dueño findDueño(Long id_dueño);
}
