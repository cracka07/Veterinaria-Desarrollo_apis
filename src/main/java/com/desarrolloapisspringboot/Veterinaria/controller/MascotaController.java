
package com.desarrolloapisspringboot.Veterinaria.controller;

import com.desarrolloapisspringboot.Veterinaria.model.Mascota;
import com.desarrolloapisspringboot.Veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascotServ;
    
    @PostMapping("/mascota/crear")
    public String crearMascota(@RequestBody Mascota mascot){
        this.mascotServ.saveMascota(mascot);
        return "Mascota creada con éxito";
    }
    @GetMapping("/mascota/get")
    public List<Mascota> getMascotas(){
        return this.mascotServ.getMascotas();
    }
     @GetMapping("/mascota/esp/raza/get")
    public List<Mascota> getEspRaza(){
        return this.mascotServ.getMascotEspRaza();
    }
     @PutMapping("/mascota/edit")
    public String editMascotas(@RequestBody Mascota mascot){
        this.mascotServ.editMascota(mascot);
        return "Editado correctamente";
    }
      @DeleteMapping("/mascota/delete/{id_mascot}")
    public String deleteMascotas(@PathVariable Long id_mascot){
        this.mascotServ.deleteMascota(id_mascot);
        return "Mascota eliminada correctamente";
    }
}
