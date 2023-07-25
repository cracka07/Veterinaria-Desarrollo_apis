
package com.desarrolloapisspringboot.Veterinaria.repository;

import com.desarrolloapisspringboot.Veterinaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDueñoRepository extends JpaRepository<Dueño,Long> {
    
}
