
package com.desarrolloapisspringboot.Veterinaria.controller;

import com.desarrolloapisspringboot.Veterinaria.dto.DueñoMascotaDTO;
import com.desarrolloapisspringboot.Veterinaria.model.Dueño;

import com.desarrolloapisspringboot.Veterinaria.service.IDueñoService;
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
public class DueñoController {
     @Autowired
    private IDueñoService dueñoServ;
    
    @PostMapping("/dueño/crear")
    public String crearDueño(@RequestBody Dueño dueño){
        this.dueñoServ.saveDueño(dueño);
        return "Dueño creado con éxito";
    }
    @GetMapping("/dueño/get")
    public List<Dueño> getDueño(){
        return this.dueñoServ.getDueño();
    }
      @GetMapping("/dueño/mascota/")
    public List<DueñoMascotaDTO> getDueñoMascota(){
        return this.dueñoServ.listarDueñoMascota();
    }
   
     @PutMapping("/dueño/edit")
    public Dueño editDueño(@RequestBody Dueño dueño){
        this.dueñoServ.editDueño(dueño);
        return this.dueñoServ.findDueño(dueño.getId());
    }
      @DeleteMapping("/dueño/delete/{id_dueño}")
    public String getDueño(@PathVariable Long id_dueño){
        this.dueñoServ.deleteDueño(id_dueño);
        return "Dueño eliminado correctamente";
    }
}

