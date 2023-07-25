
package com.desarrolloapisspringboot.Veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Dueño {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String dni;
    private String nombre_dueño;
    private String apellido_dueño;
    private String celular;
    @OneToOne
    @JoinColumn(name="id_mascota",referencedColumnName="id_mascota")
    private Mascota mascot;

    public Dueño() {
    }

    public Dueño(Long id, String dni, String nombre_dueño, String apellido_dueño, String celular, Mascota mascot) {
        this.id = id;
        this.dni = dni;
        this.nombre_dueño = nombre_dueño;
        this.apellido_dueño = apellido_dueño;
        this.celular = celular;
        this.mascot = mascot;
    }
    
    
}
