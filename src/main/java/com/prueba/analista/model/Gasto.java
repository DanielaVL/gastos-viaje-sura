package com.prueba.analista.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Gasto {
    private LocalDate fecha; // Fecha del gasto
    private BigDecimal monto; // Monto del gasto

    // Constructor
    public Gasto(LocalDate fecha, BigDecimal monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
