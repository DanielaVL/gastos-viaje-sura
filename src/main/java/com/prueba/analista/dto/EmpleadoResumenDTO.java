package com.prueba.analista.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class EmpleadoResumenDTO {
    private String nombre;
    private Map<String, List<BigDecimal>> gastosPorMes; // solo visual
    private BigDecimal totalEmpleado;
    private BigDecimal totalConIVA;
    private String quienAsume;

    // Constructor vacío
    public EmpleadoResumenDTO() {
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Map<String, List<BigDecimal>> getGastosPorMes() { return gastosPorMes; }
    public void setGastosPorMes(Map<String, List<BigDecimal>> gastosPorMes) { this.gastosPorMes = gastosPorMes; }

    public BigDecimal getTotalEmpleado() { return totalEmpleado; }
    public void setTotalEmpleado(BigDecimal totalEmpleado) { this.totalEmpleado = totalEmpleado; }

    public BigDecimal getTotalConIVA() { return totalConIVA; }
    public void setTotalConIVA(BigDecimal totalConIVA) { this.totalConIVA = totalConIVA; }

    public String getQuienAsume() { return quienAsume; }
    public void setQuienAsume(String quienAsume) { this.quienAsume = quienAsume; }
}
