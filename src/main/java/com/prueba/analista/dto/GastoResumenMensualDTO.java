package com.prueba.analista.dto;

import java.math.BigDecimal;

public class GastoResumenMensualDTO {
    private BigDecimal total;
    private BigDecimal totalConIVA;
    private String quienAsume; // "SURA" o "EMPLEADO"

    public GastoResumenMensualDTO(BigDecimal total, BigDecimal totalConIVA, String quienAsume) {
        this.total = total;
        this.totalConIVA = totalConIVA;
        this.quienAsume = quienAsume;
    }

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

    @Override
    public String toString() {
        return "GastoResumenMensualDTO{" +
                "total=" + total +
                ", totalConIVA=" + totalConIVA +
                ", quienAsume='" + quienAsume + '\'' +
                '}';
    }
}
