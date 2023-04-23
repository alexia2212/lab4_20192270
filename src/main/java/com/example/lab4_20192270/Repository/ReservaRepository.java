package com.example.lab4_20192270.Repository;

import com.example.lab4_20192270.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into reserva (idreserva, fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) VALUES (?, current_timestamp, ?, 'procesado', ?, ?)")
    void reservar(Integer reserva_id, Integer vuelo_id, Integer user_id, Integer precio_total);
}
