package com.example.lab4_20192270.Repository;

import com.example.lab4_20192270.Entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea,Integer> {
}
