package com.example.lab4_20192270.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idreserva")
    private int idreserva;
    @Basic
    @Column(name = "fecha_reserva")
    private Timestamp fechaReserva;
    @Basic
    @Column(name = "precio_total")
    private int precioTotal;
    @Basic
    @Column(name = "estado_pago")
    private String estadoPago;
    @ManyToOne
    @JoinColumn(name = "user_iduser")
    private User userIduser;
    @ManyToOne
    @JoinColumn(name = "vuelo_idvuelo")
    private Vuelo vueloIdvuelo;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

}
