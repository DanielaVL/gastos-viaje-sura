package com.prueba.analista.dto;

import java.math.BigDecimal;

public class GastoResumenMensualDTO {
    private BigDecimal total; // Total de gastos del mes
    private BigDecimal totalConIVA; // Total de gastos del mes con IVA incluido
    private String quienAsume; // "SURA" o "EMPLEADO"

    // Constructor
    public GastoResumenMensualDTO(BigDecimal total, BigDecimal totalConIVA, String quienAsume) {
        this.total = total;
        this.totalConIVA = totalConIVA;
        this.quienAsume = quienAsume;
    }

    // Getters y Setters
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalConIVA() {
        return totalConIVA;
    }

    public void setTotalConIVA(BigDecimal totalConIVA) {
        this.totalConIVA = totalConIVA;
    }

    public String getQuienAsume() {
        return quienAsume;
    }

    public void setQuienAsume(String quienAsume) {
        this.quienAsume = quienAsume;
    }
}
