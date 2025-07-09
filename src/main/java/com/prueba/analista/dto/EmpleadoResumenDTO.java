package com.prueba.analista.dto;

import java.math.BigDecimal;
import java.util.List;

public class EmpleadoResumenDTO {
    private String nombre; // Nombre del empleado
    private BigDecimal totalEmpleado; // Total de gastos del empleado
    private List<ResumenMensualDTO> resumenMensual; // Resumen mensual de gastos del empleado

    // Constructor vacío
    public EmpleadoResumenDTO() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTotalEmpleado() {
        return totalEmpleado;
    }
    
    public void setTotalEmpleado(BigDecimal totalEmpleado) {
        this.totalEmpleado = totalEmpleado;
    }

    public List<ResumenMensualDTO> getResumenMensual() {
        return resumenMensual;
    }

    public void setResumenMensual(List<ResumenMensualDTO> resumenMensual) {
        this.resumenMensual = resumenMensual;
    }
}

