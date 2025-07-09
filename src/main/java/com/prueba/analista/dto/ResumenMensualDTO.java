package com.prueba.analista.dto;

import java.math.BigDecimal;
import java.util.List;

public class ResumenMensualDTO {
    private String mes; 
    private List<BigDecimal> gastos;
    private BigDecimal totalMes;
    private BigDecimal totalConIVA;
    private String quienAsume;

    // Constructor vacío
    public ResumenMensualDTO() {
    }

    // Getters y Setters
    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public List<BigDecimal> getGastos() { return gastos; }
    public void setGastos(List<BigDecimal> gastos) { this.gastos = gastos; }

    public BigDecimal getTotalMes() { return totalMes; }
    public void setTotalMes(BigDecimal totalMes) { this.totalMes = totalMes; }

    public BigDecimal getTotalConIVA() { return totalConIVA; }
    public void setTotalConIVA(BigDecimal totalConIVA) { this.totalConIVA = totalConIVA; }

    public String getQuienAsume() { return quienAsume; }
    public void setQuienAsume(String quienAsume) { this.quienAsume = quienAsume; }
}