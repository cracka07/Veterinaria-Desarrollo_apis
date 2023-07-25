
package com.desarrolloapisspringboot.Veterinaria.service;

import com.desarrolloapisspringboot.Veterinaria.model.Mascota;

import java.util.List;


public interface IMascotaService {
    

    public void saveMascota(Mascota mascot);
    public List<Mascota> getMascotas();
    public void editMascota(Mascota mascot);
    public void deleteMascota(Long id_mascot);
    public List<Mascota> getMascotEspRaza();
        public Mascota findMascota(Long id_mascot);

}
