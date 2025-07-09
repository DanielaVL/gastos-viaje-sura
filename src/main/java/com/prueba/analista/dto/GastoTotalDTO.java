package com.prueba.analista.dto;

import java.math.BigDecimal;
import java.util.List;

public class GastoTotalDTO {
    private BigDecimal totalGeneral;
    private List<EmpleadoResumenDTO> empleados;

    // Constructor vacío
    public GastoTotalDTO() {
    }

    // Getters y Setters
    public BigDecimal getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(BigDecimal totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public List<EmpleadoResumenDTO> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoResumenDTO> empleados) {
        this.empleados = empleados;
    }
}
