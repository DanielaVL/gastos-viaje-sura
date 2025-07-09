package com.prueba.analista.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Gasto {
    private LocalDate fecha; // Usamos LocalDate para representar fechas
    private BigDecimal monto; // en millones COP

    public Gasto(LocalDate fecha, BigDecimal monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

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

    @Override
    public String toString() {
        return "Gasto{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
